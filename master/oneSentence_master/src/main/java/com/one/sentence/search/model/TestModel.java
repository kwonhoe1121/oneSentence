package com.one.sentence.search.model;

public class TestModel {
	public String toc;
	public String itemPage;
	public String title;
	
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	public String getItemPage() {
		return itemPage;
	}
	public void setItemPage(String itemPage) {
		this.itemPage = itemPage;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "TestModel [toc=" + toc + ", itemPage=" + itemPage + ", title=" + title + "]";
	}
	
	
	

}
