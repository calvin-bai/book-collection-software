package com.calvin;

import java.util.Random;

public class Scanners implements Runnable {
	private String strid;
	private Belts belt;

	public Scanners(String sid, Belts belt) {
		super();
		this.strid = sid;
		this.belt = belt;
	}

	@Override
	public void run() {
		try {
			Random r = new Random();
			for (int i = 1; i < 10; i++) {
				Books bok = new Books("" + r.nextInt(3) + "-"
						+ (i * (int) (Math.random() * 1000)));
				belt.push(bok);
				System.out.println(this + " has scanned " + bok + " onto " + belt);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getBookOfContainer(Books book) {
		return book.getBid().substring(0, 1);
	}

	public String toString() {
		return strid + " scanner";
	}

}
