package com.example.carRepairShop.PageOptions;

import org.springframework.data.domain.PageRequest;

public class PageCreate {

	int page = 0;
	int size = 10;
	
	public PageCreate setPage(int page) {
		this.page = page;
		return this;
	}
	
	public PageCreate setSize(int size) {
		this.size = size;
		return this;
	}
	
	public PageRequest buid () {
		return PageRequest.of(page, size);
	}
}
