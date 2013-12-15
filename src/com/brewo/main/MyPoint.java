package com.brewo.main;

import java.awt.Point;

public class MyPoint extends Point{

	private int i;
	
	
	public MyPoint(Point p) {
		this.i = 0;
		this.setLocation(p.getX(), p.getY());
	
	}
	
	public MyPoint(int i, double x, double y) {
		this.i = i;
		this.setLocation(x, y);
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
}
