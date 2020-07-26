package com.calvin;

import java.util.LinkedList;

public class Containers {
	private String cstrid;
	private LinkedList<Books> lin = new LinkedList<Books>();

	public Containers(String cstrid) {
		super();
		this.cstrid = cstrid;
	}

	public synchronized void push(Books book) {
		while (lin.size() == 200) {
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

	public String toString() {
		return cstrid + " container ";
	}

}
