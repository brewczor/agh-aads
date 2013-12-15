package com.brewo.main;

import java.awt.Point;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ConvexHull {

	Stack<MyPoint> finalPoints = new Stack<MyPoint>();
	
	MyPoint minPoint = null;
	
	public List<Point> getConvexHullPoints(List<MyPoint> points) {
		
		minPoint = getMinYPoint(points);
		
		List<MyPoint> substractedPoints = substractXY(points, minPoint);
		
		List<PolarPoint> sortedList = getSortedList(substractedPoints);
		
		List<PolarPoint> uniqueList = removeDuplicates(sortedList);
		
		makeStack(uniqueList);
		
		return null;
	}
	
	
	/**
	 * Returns a point with minimal y value, if there is more than one point
	 * with the same minimal value, returns the one with minimal x
	 * 
	 * @param inPoints list of input points
	 * @return point with minimal y value
	 */
	public MyPoint getMinYPoint(List<MyPoint> inPoints) {
		System.out.println("getMinYPoint");
		showPoints(inPoints);
		
		double y = inPoints.get(0).getY();
		MyPoint resultPoint = inPoints.get(0);
		int place = 0;
		
		//zwraca najmniejszy punkt
		for(int i = 0; i < inPoints.size(); i++) {
			if(inPoints.get(i).getY() == y) {
				if(inPoints.get(i).getX() < resultPoint.getX())
					resultPoint = inPoints.get(i);
			} else if(inPoints.get(i).getY() < y) {
				y = inPoints.get(i).getY();
				resultPoint = inPoints.get(i);
				place = i;
			}
		}
		
		
		
		inPoints.remove(place);
		
		return resultPoint;
	}
	
	public List<MyPoint> substractXY(List<MyPoint> inPoints, Point p) {
		System.out.println("substractXY");
		showPoints(inPoints);
		
		List<MyPoint> resultList = new LinkedList<MyPoint>();
		
		MyPoint tmp = null;
		for(MyPoint t : inPoints) {
			tmp = new MyPoint(t.getI(), t.getX() - p.getX(), t.getY() - p.getY());
			//tmp.setLocation(t.getX() - p.getX(), t.getY() - p.getY());
			
			resultList.add(tmp);
		}
		return resultList;
	}
	
	public List<PolarPoint> getSortedList(List<MyPoint> inPoints) {
		System.out.println("getSortedList");
		showPoints(inPoints);
		
		List<PolarPoint> resultList = new LinkedList<PolarPoint>();
		
		for(MyPoint p : inPoints) {
			resultList.add(new PolarPoint(p));
		}
		
		for(PolarPoint pp : resultList) {
			System.out.println("PolarPoint: X:" + pp.getX() + " Y:" +pp.getY() + " Radius: " 
		+ pp.getRadius() + " Length: " + pp.getLength());
		}		
		
		Collections.sort(resultList);
		Collections.reverse(resultList);
		for(PolarPoint pp : resultList) {
			System.out.println("PolarPoint: X:" + pp.getX() + " Y:" +pp.getY() + " Radius: " 
		+ pp.getRadius() + " Length: " + pp.getLength());
		}
		
		return resultList;
	}
	

	public List<PolarPoint> removeDuplicates(List<PolarPoint> inPolarPoints) {
		System.out.println("removceDuplicates");
		
		showPolarPoints(inPolarPoints);
		
		for(int i = 1; i < inPolarPoints.size() ; i++) {
			System.out.println("Licznik: " + i);
			System.out.println(i + " value: " + inPolarPoints.get(i).getRadius());
			System.out.println(i-1 + " value: " + inPolarPoints.get(i-1).getRadius());

			if(inPolarPoints.get(i).getRadius() == inPolarPoints.get(i-1).getRadius()) {
				System.out.println("Rowne");
				inPolarPoints.remove(i);
				i--;
			}
				
		}
		System.out.println("out");
		showPolarPoints(inPolarPoints);
		
		return inPolarPoints;
	}	
	
	public void makeStack(List<PolarPoint> inPoints) {
		System.out.println("makeStac");
		
		finalPoints.push(new MyPoint(minPoint.getI(),0,0));
		finalPoints.push(inPoints.get(0));
		finalPoints.push(inPoints.get(1));
		
		
		PointFinder helper = new PointFinder();
		
		for(int i = 2; i < inPoints.size(); i++) {
			while(helper.rightOrLeft(finalPoints.peek(), finalPoints.get(finalPoints.size() - 2), inPoints.get(i)) == -1)
				finalPoints.pop();
			finalPoints.push(inPoints.get(i));
		}
		
		
		System.out.println("minPoint" + minPoint.getX() + " " + minPoint.getY());
		for(Point p : finalPoints) {
			p.setLocation(p.getX() + minPoint.getX(), p.getY() + minPoint.getY());
		}
		
		showPoints(finalPoints.subList(0, finalPoints.size()));
		System.out.println("------------");
		showPoints(finalPoints);
		
	}
	
	
	public void showPoints(List<MyPoint> inPoints) {
		for(MyPoint p : inPoints) {
			System.out.println("PolarPoint " + p.getI() + ": X:" + p.getX() + " Y:" + p.getY());
		}
	}
	
	public void showPolarPoints(List<PolarPoint> inPolarPoints) {
		for(PolarPoint pp : inPolarPoints) {
			System.out.println("PolarPoint: X:" + pp.getX() + " Y:" +pp.getY() + " Radius: " 
		+ new BigDecimal(pp.getRadius()).toString() + " Length: " + pp.getLength());
		}
	}
} 


// IN P1, ... PN
// OUT: CH = (Pi1, Pi2, ... , Pik)

//