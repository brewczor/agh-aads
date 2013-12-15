package com.brewo.main;

import java.awt.Point;

public class PolarPoint extends MyPoint implements Comparable<PolarPoint>{

	double x;
	double y;
	
	double length = 0;
	double radius;
	
	
	public PolarPoint(MyPoint p) {
		super(p);
		x = p.getX();
		y = p.getY();
		
		length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		radius = calculateRadius(p);
		
		setI(p.getI());
	}
	
	//dopisac cos z zerem jak length
	public double calculateRadius(Point p){
		//if(length == 0)
			//throw new Exception("Length equals 0");
		
		if(x > 0 && y >= 0) return Math.atan(y/x);
		if(x > 0 && y < 0) return Math.atan(y/x) + 2*Math.PI;
		if(x < 0) return Math.atan(y/x) + Math.PI;
		if(x == 0 && y > 0) return Math.PI/2;
		if(x == 0 && y < 0) return 3*Math.PI/2;
		
		return 0;
	}
	
	
	public int whichQuater(Point p) {
		
		if(p.getX() > 0 && p.getY() > 0) return 1;
		if(p.getX() < 0 && p.getY() > 0) return 2;
		if(p.getX() < 0 && p.getY() < 0) return 3;
		if(p.getX() > 0 && p.getY() < 0) return 4;
		return 0;
		
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	
	public double getLength() {
		return length;
	}
	
	public double getRadius() {
		return radius;
	}

	@Override
	public int compareTo(PolarPoint p) {
		if(this.getRadius() > p.getRadius()) return 1;
		if(this.getRadius() < p.getRadius()) return -1;
		if(this.getLength() > p.getLength()) return 1;
		if(this.getLength() < p.getLength()) return -1;
		
		return 0;
	}
}
