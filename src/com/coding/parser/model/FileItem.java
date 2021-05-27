package com.coding.parser.model;

public class FileItem implements Comparable<FileItem> {

	private int index;
	private String token;
	
	public FileItem(String token, int index) {
		super();
		
		this.token = token;
		this.index = index;
	}
	
	@Override
	public int compareTo(FileItem item) {
		return this.index - item.index;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "[Token " + token + " at index " + index + "]";
	}
}
