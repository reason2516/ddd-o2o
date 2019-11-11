package com.wmx.o2o.common.pojos;

public class BaseQO implements Pageable {

    // 分页信息
    public PageQO page;

    @Override
    public PageQO getPage() {
        return page;
    }

    @Override
    public void setPage(PageQO page) {
        this.page = page;
    }
}
