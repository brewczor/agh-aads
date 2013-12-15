package com.brewo.main;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class FirstTask {

	public static void main(String[] args) {
		System.out.println("FirstTask");
		//punktA
		Point A = new Point(0,0);
		
		//punkt B
		Point B = new Point(50,50);
		
		//punkt C
		Point C = new Point(2,0);
		
		//punkt D
		Point D = new Point(2,5);
		
		
//		PointFinder helper = new PointFinder();
//		System.out.println(helper.crossEachOther(A, B, C, D));
		//testSecondTask();
		
//		testThirdTask();		
		
		testGraham3();
	}
	
	public static void testSecondTask() {
		Point A = new Point(0,0);
		Point B = new Point(100,100);
		
		List<Point> Points = new LinkedList<Point>();
		Points.add(new Point(0,0));
		Points.add(new Point(2,0));
		Points.add(new Point(3,1));
		Points.add(new Point(1,2));
		Points.add(new Point(-1,1));
		
		
		PointFinder helper = new PointFinder();
		System.out.println(helper.howManyCrosses(Points));
//		Points.add(new Point(100,2));
//		
//		Points.add(new Point(160,2));
//		
//		Points.add(new Point(5,5));
//		
//		PointFinder helper = new PointFinder();
//		List<List<Point>> result = helper.multipleRigtOrLeft(A, B, Points);
//		
//		for(List l : result) {
//			System.out.println(l.size());
//		}
		
	//	System.out.print(helper.rightOrLeft(A, B, C));
		
		
		
	}
	
	public static void testThirdTask() {
		Point A = new Point(0,0);
		Point B = new Point(100,100);
		
		List<Point> ps = new LinkedList<Point>();
		//Points.add(new Point(-100, -100));
//		Points.add(new Point(0,0));
//		Points.add(new Point(4,0));
//		Points.add(new Point(4,4));
//		Points.add(new Point(0,4));
//		Points.add(new Point(2,1));
//		Points.add(new Point(1,2));
//		Points.add(new Point(1,1));
//		Points.add(new Point(1,1));
//		Points.add(new Point(0,0));
//		Points.add(new Point(0,2));
//		Points.add(new Point(0,0));
//		Points.add(new Point(0,2));
//		Points.add(new Point(0,2));
//		Points.add(new Point(1,1));
		
		
		 ps.add(new Point(7, 7));
	        ps.add(new Point(7, -7));
	        ps.add(new Point(-7, -7));
	        ps.add(new Point(-7, 7));
	        ps.add(new Point(9, 0));
	        ps.add(new Point(-9, 0));
	        ps.add(new Point(0, 9));
	        ps.add(new Point(0, -9));
	        ps.add(new Point(0, 0));
	        ps.add(new Point(1, 2));
	        ps.add(new Point(-2, 1));
	        ps.add(new Point(-1, -1));
	        ps.add(new Point(3, 4));
	        ps.add(new Point(4, 3));
	        ps.add(new Point(-5, 4));
	        ps.add(new Point(6, 5));
		
		ConvexHull t = new ConvexHull();
		
	//	t.getConvexHullPoints(ps);
	}
		
		
		//PointFinder helper = new PointFinder();
		//System.out.println(helper.howManyCrosses(Points));
	

	public static void testGraham() {
		
		List<Point> ps = new LinkedList<Point>();
		ps.add(new Point(14, 56));
		ps.add(new Point(46, 89));
		ps.add(new Point(99, 8));
		ps.add(new Point(77, 32));
		ps.add(new Point(60, 82));
		ps.add(new Point(16, 98));
		ps.add(new Point(66, 69));
		ps.add(new Point(81, 22));
		
		ps.add(new Point(77, 18));
		ps.add(new Point(77, 23));
		ps.add(new Point(39, 7));
		ps.add(new Point(69, 95));
		ps.add(new Point(15, 78));
		ps.add(new Point(70, 9));
		ps.add(new Point(36, 20));
		ps.add(new Point(6, 27));
		ps.add(new Point(44, 68));
		ps.add(new Point(49, 48));
		
		ps.add(new Point(35, 26));
		ps.add(new Point(54, 98 ));
		ps.add(new Point(54, 98));
		ps.add(new Point(31, 2));
		ps.add(new Point(63, 92));
		ps.add(new Point(37, 22));
		
		ps.add(new Point(3, 3));
		ps.add(new Point(43, 81));
		
ConvexHull t = new ConvexHull();
		
	//	t.getConvexHullPoints(ps);
	}
	
	
public static void testGraham2() {
		
		List<MyPoint> ps = new LinkedList<MyPoint>();
		ps.add(new MyPoint(1, 14, 56));
		ps.add(new MyPoint(2, 46, 89));
		ps.add(new MyPoint(3, 99, 8));
		ps.add(new MyPoint(4, 77, 32));
		ps.add(new MyPoint(5, 60, 82));
		ps.add(new MyPoint(6, 16, 98));
		ps.add(new MyPoint(7, 66, 69));
		ps.add(new MyPoint(8, 81, 22));
		
		ps.add(new MyPoint(9, 77, 18));
		ps.add(new MyPoint(10, 77, 23));
		ps.add(new MyPoint(11, 39, 7));
		ps.add(new MyPoint(12, 69, 95));
		ps.add(new MyPoint(13, 15, 78));
		ps.add(new MyPoint(14, 70, 9));
		ps.add(new MyPoint(15, 36, 20));
		ps.add(new MyPoint(16, 6, 27));
		ps.add(new MyPoint(17, 44, 68));
		ps.add(new MyPoint(18, 49, 48));
		
		ps.add(new MyPoint(19, 35, 26));
		ps.add(new MyPoint(20, 54, 98 ));
		ps.add(new MyPoint(21, 54, 98));
		ps.add(new MyPoint(22, 31, 2));
		ps.add(new MyPoint(23, 63, 92));
		ps.add(new MyPoint(24, 37, 22));
		
//		ps.add(new MyPoint(3, 3));
//		ps.add(new MyPoint(43, 81));
		
ConvexHull t = new ConvexHull();
		
		t.getConvexHullPoints(ps);
	}

public static void testGraham3() {
	int[][] tablica = {
			 { 0, 14, 56 }, 
			  { 1, 46, 89 }, 
			  { 2, 99, 8 }, 
			  { 3, 77, 32 }, 
			  { 4, 60, 82 }, 
			  { 5, 16, 98 }, 
			  { 6, 66, 69 }, 
			  { 7, 81, 22 }, 
			  { 8, 77, 18 }, 
			  { 9, 77, 23 }, 
			  { 10, 39, 7 }, 
			  { 11, 69, 95 }, 
			  { 12, 15, 78 }, 
			  { 13, 70, 9 }, 
			  { 14, 36, 20 }, 
			  { 15, 6, 27 }, 
			  { 16, 44, 68 }, 
			  { 17, 49, 48 }, 
			  { 18, 35, 26 }, 
			  { 19, 54, 98 }, 
			  { 20, 31, 2 }, 
			  { 21, 63, 92 }, 
			  { 22, 37, 22 }, 
			  { 23, 3, 3 }, 
			  { 24, 43, 81 }, 
			 };
	
	
	List<MyPoint> p = new LinkedList<MyPoint>();
	for(int[] x : tablica) {
		p.add(new MyPoint(x[0], x[1], x[2]));
	}
	
	ConvexHull t = new ConvexHull();
	
	t.getConvexHullPoints(p);
}
}

		
		

	
	
	
	

	/*
	 * D = det [x1,y1,1; x2,y2,1; x3,y3,1]
	 */
	//jesli D>0 -> lewa
	//jesli D=0 -> na linii
	//jesli D<0 -> prawa
	// D = x1(y2-y3) - y1(x2-x3) + x2y3 - y2x3
	
	
	//mnozenie wielomianow
	//transformata fouriera szybka

