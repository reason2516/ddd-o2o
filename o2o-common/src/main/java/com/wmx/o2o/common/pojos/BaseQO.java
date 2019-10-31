package com.wmx.o2o.common.pojos;

public class BaseQO {

    public static final Integer MAX_PAGE_SIZE = 1000;
    public static final Integer DEFAULT_PAGE_SIZE = 20;
    public static final Integer DEFAULT_PAGE_INDEX = 1;

    private Integer pageSize;

    private Integer pageIndex;

    public Integer getPageSize() {
        // 默认值
        return (pageSize == null || pageSize == 0) ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        // 默认值
        return (pageIndex == null || pageIndex == 0) ? DEFAULT_PAGE_INDEX : pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 设置最大页码
     */
    public void setPageSIzeToMax() {
        this.pageSize = BaseQO.MAX_PAGE_SIZE;
    }
}
