package com.demo.domain;

/**
 * @author wwx
 * @date 2019/1/4 8:58
 **/

import java.util.List;

/**
 * 分页页面实体类
 */
public class PageUtil<T>{

    private int pageNumber;//总记录数
    private int pageCount;//总页数
    private int pageIndex;//当前页
    private int pageSize;//每页大小
    private List<T> list;//当前页的数据

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
