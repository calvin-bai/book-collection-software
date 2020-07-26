package com.calvin.test;

import com.calvin.Belts;
import com.calvin.Containers;
import com.calvin.Scanners;
import com.calvin.Turntables;

public class BookCollectionSoftware{
	
	
	public static void main(String[] args){
		System.out.println("Starting the system, please wait 5 second....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Scanning......");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Belts b1=new Belts("b1");
		Belts b2=new Belts("b2");
		Belts b3=new Belts("b3");
		Belts b4=new Belts("b4");
		
		Scanners s1=new Scanners("s1",b1);
		Scanners s2=new Scanners("s2",b2);
		
		Containers c1=new Containers("c1");
		Containers c2=new Containers("c2");
		//Containers c3=new Containers("c3");
		
		Turntables tA=new Turntables("tA",b1,c1);
		tA.setBelt1(b3);
		Turntables tB=new Turntables("tB",b2,c2);
		tB.setBelt1(b4);
		
		//Turntables t3=new Turntables("t3",b);
		
		new Thread(s1).start();
		new Thread(s2).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(tA).start();
		new Thread(tB).start();
	}
}
