package com.qa.beans;

public class PropertyBean {

	
	public String key1;
	
	public String key2;

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}
	
	public String toString(){
		return this.key1+" : "+this.key2;
	}
	
}