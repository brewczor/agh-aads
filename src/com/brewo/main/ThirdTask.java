package com.brewo.main;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThirdTask {

	public static void main(String[] args) {
		List<MyPoint> testPoints = new LinkedList<MyPoint>();
		
		testPoints.add(new MyPoint(0,0,0));
		testPoints.add(new MyPoint(1,0,9));
		testPoints.add(new MyPoint(2,0,5));
		//testPoints.add(new MyPoint(2,0,10));
		//testPoints.add(new MyPoint(2,2,100));
		
		ThirdTask helper = new ThirdTask();
		//this.get
		
		String scieka = "aaa";
		List<MyPoint> testP = helper.parseCsv("aaa");
		
		
		helper.getMaxCollinearPoints(testP);
		
	}
	
	public int rightOrLeft(MyPoint A, MyPoint B, MyPoint C) {
		/*
		System.out.println("rightOrLeft");
		System.out.println("A: " + A.getX() + "/" + A.getY());
		System.out.println("B: " + B.getX() + "/" + B.getY());
		System.out.println("C: " + C.getX() + "/" + C.getY());
		*/
		//LEZLEZLE
//		double d =  ((double)A.getX()*100)/100 * (B.getY()*100)/100 - C.getY()) 
//				- A.getY() * (B.getX() - C.getX()) 
//				+ B.getX() * C.getY()
//				- B.getY() * C.getX();
		
		double d = 0;
		//System.out.println("d: " + d);
		if(d < 5 && d > -5)
			return 0;
		if(d > 0)
			return 1; // lewo
		if(d < 0)
			return -1; // prawo
		
		return -2;
					
	}
	
	
	public int getMaxCollinearPoints(List<MyPoint> inPoints) {
		List<Segment> segments = createSegments(inPoints);
		
		List<Integer> resultList = new LinkedList<Integer>();
		
		for(int i = 0; i < segments.size(); i++) {
			int res = calculatePointsForSegment(segments.get(i), inPoints);
			resultList.add(new Integer(res));
		}
		
		int res1 = 0;
		for(int i = 0; i < resultList.size(); i++) {
			//System.out.println(i + ". " + resultList.get(i));
			
			if(resultList.get(i) > res1 && resultList.get(i) != 221)
				res1 = resultList.get(i);
		}
		
		
		System.out.println("Wynik: " + res1);
		
		return 0;
	}
	
	
	private List<Segment> createSegments(List<MyPoint> inPoints) {
		List<Segment> segments = new LinkedList<Segment>();
		
		for(int i = 0; i < inPoints.size(); i++) {
			for(int j = i; j < inPoints.size(); j++) {
				if(inPoints.get(i) == inPoints.get(j))
					continue;
				segments.add(new Segment(inPoints.get(i), inPoints.get(j)));			
			}
		}
		
		System.out.println("Segment size: " + segments.size() );
		
		return segments;
	}
	
	private int calculatePointsForSegment(Segment currSeg, List<MyPoint> inPoints) {
		//System.out.println("calculatePointsForSegment");
		//Segment tmpSegment = segments.get(0);
		
		//MyPoint p = inPoints.get(0);
		//System.out.println("inPoints: " + inPoints.size());
		
		MyPoint p1 = new MyPoint(currSeg.getA());
		MyPoint p2 = new MyPoint(currSeg.getB());
		int x = 0;
		for(int i = 0; i < inPoints.size(); i++) {
			if(rightOrLeft(p1, p2, inPoints.get(i)) == 0)
				x++;
		}
		
		//System.out.println("x: " + x);
		
		return x;
	}
	
	

    public List<MyPoint> parseCsv(String f) {
            List<MyPoint> ps = new ArrayList<>();
            try {
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String line = br.readLine();
                    while (line != null) {
                            System.out.println(line);
                            System.out.println(ps.size());
                            int idx = Integer.parseInt(line.split(";")[0].trim());
                            float x = Float.parseFloat(line.split(";")[1].replace(",", ".").trim());
                            float y = Float.parseFloat(line.split(";")[2].replace(",", ".").trim());
                            MyPoint p = new MyPoint(idx, x, y);
                            ps.add(p);
                            line = br.readLine();
                    }
            } catch (Exception e) {
                    System.err.println("Error occured: " + e.getMessage());
            }
            return ps;
    }
    
    
    
   
	
	

}
