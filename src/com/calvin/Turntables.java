package com.calvin;

public class Turntables implements Runnable {
	private String tname;
	private Belts belt2;
	private Belts belt1;
	private Containers c;

	public Turntables(String tname, Belts belt,Containers c) {
		super();
		this.tname = tname;
		this.belt2 = belt;
		this.c=c;
	}

	public Turntables(Belts belt1) {
		super();
		this.belt1 = belt1;
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				this.ScannerOfTurntable();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void ScannerOfTurntable() {
		try {
			for (int i = 1; i < 10; i++) {
				if (belt2.getBid().equals("b1")) {
					Books book = belt2.pop();
					System.out.println(belt2 + " put " + book + " onto " + this);
					Thread.sleep(1000);
					c.push(book);
					System.out.println("After 2 seconds"+belt2 + " put " + book + " into "+c );
					Thread.sleep(2000);
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Belts getBelt() {
		return belt2;
	}

	public void setBelt(Belts belt) {
		this.belt2 = belt;
	}

	public Belts getBelt1() {
		return belt1;
	}

	public void setBelt1(Belts belt1) {
		this.belt1 = belt1;
	}

	public String toString() {
		return tname + " turntable ";
	}

}
