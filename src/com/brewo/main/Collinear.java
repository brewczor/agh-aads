package com.brewo.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Collinear {

	public static void main(String[] args) throws IOException {

		Collinear col = new Collinear();

		col.maxCollinear(col.getData("colinear.csv"));
		// col.getData2();
	}

	public boolean isCollinear(Point A, Point B, Point C) {

		double d = A.getX() * (B.getY() - C.getY()) - A.getY()
				* (B.getX() - C.getX()) + B.getX() * C.getY() - B.getY()
				* C.getX();

		if (Math.abs(d) < 0.001)
			return true;

		return false;
	}

	private List<Point> getData(String filePath) throws IOException {
		List<Point> resultList = new LinkedList<Point>();

		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String textLine = bufferedReader.readLine();
		String[] splitted;
		do {

			// System.out.println(textLine.trim());

			splitted = textLine.trim().replace(",", ".").split(";");
			//System.out.println(new Double(splitted[1].trim()));
			resultList.add(new MyPoint(new Integer(splitted[0].trim()),
					new Double(splitted[1].trim()), new Double(splitted[2]
							.trim())));
			// System.out.println(textLine);

			textLine = bufferedReader.readLine();
		} while (textLine != null);

		bufferedReader.close();

//		System.out.println("pointList size: " + resultList.size());
//		for(int i = 0; i < resultList.size(); i++) {
//			System.out.println("P: " + ((MyPoint)resultList.get(i)).getIndex() + "/"+ resultList.get(i).getX() + "/" 
//						+ resultList.get(i).getY());
//		}

		return resultList;

	}


	public int maxCollinear(List<Point> inList) {
		
		List<Segment> segments= new LinkedList<Segment>();
		for (int i = 0; i < inList.size(); i++) {
			for(int j = i+1; j < inList.size(); j++) {
				segments.add(new Segment(inList.get(i), inList.get(j)));
				
			}
		}
		
		int count = 0;
		int max = 0;
		for(Segment s : segments) {
			for(int i = 0; i < inList.size(); i++) {
				if(isCollinear(s.getA(), s.getB(), inList.get(i)))
					count++;
			}
			
			if(count > max) {
				max = count;
			}
			count = 0;
		}
		
		System.out.println("Segments count: " + segments.size());

		System.out.println("Wynik: " + max);
		return max;
	}
	
	
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

	public class MyPoint extends Point {

		private int index = 0;
		private double x = 0;
		private double y = 0;
		
		public MyPoint(int i, double x, double y) {
			index = i;

			this.x = x;
			this.y = y;
			
			//System.out.println(x + " " + y);

		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
		
		
	}
}
