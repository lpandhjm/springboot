package com.pei.liu.springboot.utils;

import com.github.pagehelper.Page;

import java.util.Collection;
import java.util.List;

public class PagedResponse<T>
{
	private static final long serialVersionUID = 1L;
    //当前页
    private int pageNo;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;

    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;

   

    public PagedResponse() {
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PagedResponse(List<T> list) {
        this(list, 8);
    }

    /**
     * 包装Page对象
     *
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public PagedResponse(List<T> list, int navigatePages) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
            this.total = page.getTotal();
           
        } else if (list instanceof Collection) {
            this.pageNo = 1;
            this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.size = list.size();
            this.total = list.size();
        }

    }
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNum) {
        this.pageNo = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
   
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
