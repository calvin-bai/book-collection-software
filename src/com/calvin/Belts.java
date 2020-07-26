package com.calvin;

import java.util.LinkedList;

public class Belts {

	private String baaid;
	private LinkedList<Books> lin = new LinkedList<Books>();

	public Belts(String bid) {
		super();
		this.baaid = bid;
	}

	public Belts(String bid, LinkedList<Books> lin) {
		super();
		this.baaid = bid;
		this.lin = lin;
	}

	public synchronized void push(Books book) {
		while (lin.size() == 4) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		this.lin.addLast(book);
	}

	public synchronized Books pop() {
		while (lin.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		Books b = lin.getFirst();
		lin.removeFirst();
		return b;
	}

	public String getBid() {
		return baaid;
	}

	public void setBid(String bid) {
		this.baaid = bid;
	}

	public LinkedList<Books> getLin() {
		return lin;
	}

	public void setLin(LinkedList<Books> lin) {
		this.lin = lin;
	}

	public String toString() {
		return baaid + " belt";
	}

}
