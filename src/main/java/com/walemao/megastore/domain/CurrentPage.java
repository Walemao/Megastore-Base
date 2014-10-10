package com.walemao.megastore.domain;

import java.util.ArrayList;
import java.util.List;

public class CurrentPage<E> {

	public static ThreadLocal<Integer> pageNubmer = new ThreadLocal<Integer>();
	public static ThreadLocal<Integer> pageLength= new ThreadLocal<Integer>();
	
	private int pageAvailable;
	private int pageNo;
	private int pageSize;
    private List<E> pageItems = new ArrayList<E>();  
    
    public CurrentPage(){
    	CurrentPage.pageNubmer.set(1);
    	CurrentPage.pageLength.set(15);
    }
    
    public static int getPageNubmer() {
		return pageNubmer.get();
	}
    
    public static int getPageLength() {
		return pageLength.get();
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		CurrentPage.pageNubmer.set(pageNo);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		CurrentPage.pageLength.set(pageSize);
	}

	public int getPageAvailable() {
		return pageAvailable;
	}

	public void setPageAvailable(int pageAvailable) {
		this.pageAvailable = pageAvailable;
	}

	public void setPageItems(List<E> pageItems) {  
        this.pageItems = pageItems;  
    }  
   
    public List<E> getPageItems() {  
        return pageItems;  
    }  
}
