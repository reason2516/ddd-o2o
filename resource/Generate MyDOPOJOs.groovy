import com.intellij.database.model.DasTable
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil
import java.io.*

/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */
// TODO 生成相关的pojo 如 qo dto 查询等
// pojo 所在包名
packageName = "com.xxx.xxx.entity;"
// 表前缀
//tablePrefix = "cu_"
tablePrefix = ""
// pojo 前缀
doPrefix = ""
// pojo 后缀
doSuffix = "DO"
// 主键
primaryKey = "id"
// 乐观锁
optimisticLockField = "version"
// 更新时间
updateTimeField = "updateTime"
// 创建时间
createTImeField = "createTime"

typeMapping = [
        (~/(?i)\sint/)             : "Integer",
        (~/(?i)bigint/)            : "Long",
        (~/(?i)tinyint/)           : "Byte",
        (~/(?i)decimal/)           : "BigDecimal",
        (~/(?i)float|double|real/) : "Double",
        (~/(?i)datetime|timestamp/): "Date",
        (~/(?i)date/)              : "Date",
        (~/(?i)time/)              : "Date",
        (~/(?i)/)                  : "String"
]
FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
    SELECTION.filter { it instanceof DasTable }.each { generate(it, dir) }
}

def generate(table, dir) {
//    def tableNameDispose = table.getName().substring((table.getName().indexOf(table_prefix)), table.getName().length())
    def tableNameDispose = table.getName().substring(tablePrefix.length(), table.getName().length())
    out.println tableNameDispose
    def className = doPrefix + javaName(tableNameDispose, true) + doSuffix
    out.println className
    def fields = calcFields(table)
    PrintWriter output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + ".java")), "utf-8"))
    output.withPrintWriter { out -> generate(out, className, fields, table.getName()) }
}

def generate(out, className, fields, tableName) {
    def imports = [:]
    fields.each() {
        if (isNotEmpty(it.type) && it.type == "Date") {
            imports.put("Date", "import java.util.Date;")
        }
        if (isNotEmpty(it.type) && it.type == "BigDecimal") {
            imports.put("BigDecimal", "import java.math.BigDecimal;")
        }
    }
    out.println "package $packageName"

    out.println "import java.io.Serializable;" // 实现Serializable
//    out.println "import javax.persistence.Entity;"
    out.println "import javax.persistence.*;"
    out.println "import org.hibernate.annotations.DynamicUpdate;"
    out.println "import org.hibernate.annotations.DynamicInsert;"
    out.println "import org.springframework.data.annotation.CreatedDate;"
    out.println "import org.springframework.data.annotation.LastModifiedDate;"
    out.println "import org.springframework.data.jpa.domain.support.AuditingEntityListener;"
// 引入 long包之外的类型
    imports.each { key, value ->
        out.println "${value}"
    }
    out.println ""
    out.println "@Entity"
    out.println "@DynamicInsert"
    out.println "@DynamicUpdate"
    out.println "@EntityListeners(AuditingEntityListener.class)"
    out.println "@Table(name = \"${tableName}\")"
    out.println "public class $className implements Serializable{"
//    out.println "public class $className {"
    out.println ""
    def msum = (long) (Math.random() * 1000000000000000000 + 1000000000000000000)
    out.println "  private static final long serialVersionUID = ${msum}L;"

    fields.each() {
        if (isNotEmpty(it.commoent)) {
            out.println ""
            out.println "    // ${it.commoent}"
        }else{
            out.println ""
        }
        // 主键注解
        if (it.name == primaryKey) {
            out.println "    @Id"
            out.println "    @GeneratedValue(strategy = GenerationType.IDENTITY)"
        }
        // 乐观锁注解
        if(it.name == optimisticLockField){
            out.println "    @Version"
        }
        // 更新时间
        if(it.name == updateTimeField){
            out.println "    @LastModifiedDate"
        }
        // 创建时间时间
        if(it.name == createTImeField){
            out.println "    @CreatedDate"
        }
        if (it.annos != "") out.println "    ${it.annos}"
        out.println "    private ${it.type} ${it.name};"
    }
    out.println ""
    fields.each() {
        out.println ""
        out.println "    public ${it.type} get${it.name.capitalize()}() {"
        out.println "        return ${it.name};"
        out.println "    }"
        out.println ""
        out.println "    public void set${it.name.capitalize()}(${it.type} ${it.name}) {"
        out.println "        this.${it.name} = ${it.name};"
        out.println "    }"
        out.println ""
    }
    out.println "}"
}

def calcFields(table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        def spec = Case.LOWER.apply(col.getDataType().getSpecification())
        def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value
        fields += [[
                           name    : javaName(col.getName(), false),
                           type    : typeStr,
                           colName : col.getName(),
                           commoent: col.getComment(),
                           annos   : "@Column(name = \"${col.getName()}\")"]]
    }
}

def javaName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

def isNotEmpty(content) {
    return content != null && content.toString().trim().length() > 0
}