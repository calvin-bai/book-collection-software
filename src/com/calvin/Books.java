package com.calvin;

public class Books {

	private String bid;

	public Books(String bid) {
		super();
		this.bid = bid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String toString() {
		return "book:" + bid;
	}

}
