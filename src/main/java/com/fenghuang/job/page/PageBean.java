package com.fenghuang.job.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/11 18:05
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class PageBean <T>{

    private Integer pageNum;

    private Integer pageSize;

    private Long count;
    private Long pages;

    private List<T> records;

    public PageBean(Integer pageNum, Integer pageSize, Long count, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
        this.records = data;
        this.pages = count % pageSize == 0 ? count / pageSize : count / pageSize +1;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
