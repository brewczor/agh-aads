package com.brewo.main;

import java.awt.Point;

public class Segment {
	Point A;
	Point B;
	
	public Segment(Point A, Point B) {
		this.A = A;
		this.B = B;
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}
	
	
}
