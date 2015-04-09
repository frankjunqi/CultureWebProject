package com.lxy.util;

import java.util.List;

import com.lxy.base.model.Need2JSON;


public class Pagination {
	
	@Need2JSON
	private int pageSize; 

	@Need2JSON
    private List<?> items; 

	@Need2JSON
    private int totalCount; 

    @Need2JSON
    private int startIndex = 0;

	public int getPageSize() {
		return pageSize;
	}
	public static Pagination convertToPagination(PaginationSupport ps) {
		Pagination pagination=new Pagination();
		pagination.setItems(ps.getItems());
		pagination.setPageSize(ps.getPageSize());
		pagination.setTotalCount(ps.getTotalCount());
		pagination.setStartIndex(ps.getStartIndex());
		return pagination;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	} 
}
