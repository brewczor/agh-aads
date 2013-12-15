package com.brewo.main;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class PointFinder {
	public int rightOrLeft(Point A, Point B, Point C) {
		
		double d = A.getX()*(B.getY() - C.getY()) 
				- A.getY()*(B.getX() - C.getX()) 
				+ B.getX() * C.getY()
				- B.getY() * C.getX();
		
		if(d > 0)
			return 1; // lewo
		else if (d == 0)
			return 0;
		else
			return -1; // prawo
					
	}
	
	public List<List<Point>> multipleRigtOrLeft(Point A, Point B, List<Point> pointList) {
		
		List<Point> Sl = new LinkedList<Point>();
		List<Point> Sr = new LinkedList<Point>();
		List<Point> Sc = new LinkedList<Point>();
		
		Point TMP = null;
		for(int i = 0; i < pointList.size(); i++) {
			TMP = pointList.get(i);
			
			if(rightOrLeft(A, B, TMP) == 1)
				Sl.add(TMP);
			else if(rightOrLeft(A, B, TMP) == -1)
				Sr.add(TMP);
			else
				Sc.add(TMP);
		}
		
		List<List<Point>> returnList = new LinkedList<List<Point>>();
		returnList.add(Sl);
		returnList.add(Sr);
		returnList.add(Sc);
		
		return returnList;
	}
	
	/**
	 * Sprawdza czy dwa odcinki (A,B), (C,D) przecinaja sie
	 */
	public int crossEachOther(Point A, Point B, Point C, Point D) {
		
		// czy ktorys punkt koncowy odcinka lezy na drugim odcinku
		if(onTheLine(A,B,C) || onTheLine(A,B,D) 
				|| onTheLine(C,D,A) || onTheLine(C,D,B)) {
			return 0;
		}
		
		int detC = rightOrLeft(A, B, C);
		int detD = rightOrLeft(A, B, D);
		
		int detA = rightOrLeft(C, D, A);
		int detB = rightOrLeft(C, D, B);
		
		
		//sprawdzenie czy punkty sa po dwoch stronach odcinka
		if((detC!=detD) && (detA!=detB)) {
			return 1;
		}
	
		return -1;
	}
	
	
	public boolean onTheLine(Point A, Point B, Point C) {
		
		int detC = rightOrLeft(A, B, C);
		if(detC != 0)
			return false; //C nie lezy na tej samej linii
		
		if (!((Math.min(A.getX(), B.getX()) <= C.getX()) 
				&& (C.getX() <= Math.max(A.getX(),  B.getX()))) ){
				return false;//C nie jest w osi X na szerokosci AB
			}
			
		if (! ((Math.min(A.getY(), B.getY()) <= C.getY()) 
				&& (C.getY() <= Math.max(A.getY(),  B.getY()))) ){
				return false;	//C nie jest w osi Y na wysokosci AB
			}
		
		return true;
	}
	
	public int howManyCrosses(List<Point> points) {
		
		List<Segment> segments = new LinkedList<Segment>();
		
		for(int i = 0; i < points.size(); i++) {
			for(int j = i; j < points.size(); j++) {
				segments.add(new Segment(points.get(i), points.get(j)));			
			}
		}
		
		int count = 0;
		Segment a = null;
		Segment b = null;
		for(int i = 0; i < segments.size(); i++) {
			for(int j = 0; j < segments.size(); j++) {
				a = segments.get(i);
				b = segments.get(j);
				
				if(crossEachOther(a.getA(), a.getB(), b.getA(), b.getB()) == 1) {
					count++;
				}
			}
		}
		
		return count/2;
	}
}







/*Dane są odcinki |AB| i |CD|, gdzie A=(2,2), B=(10,7), C=(3,8), D=(8,1). Mamy sprawdzić, czy odcinki się przecinają.
W pierwszym kroku musimy sprawdzić, 
czy punkty żadnego z odcinków nie należą do drugiego odcinka, 
w tym celu sprawdzamy najpierw dla każdego punktu obu odcinków, 
czy jest on współliniowy z drugim odcinkiem, 
czyli wyliczamy wyznaczniki det(A,B,C), det(A,B,D), det(C,D,A) oraz det(C,D,B). 
W naszym przykładzie żaden z wyznaczników nie miał wartości 0, 
nie ma więc współliniowości punktów żadnego z odcinków z żadnym punktem drugiego odcinka. Przechodzimy więc do sprawdzania dwóch nierówności (także dla każdych trzech punktów):
min(x1, x2) <= x3 <= max(x1, x2) oraz min(y1, y2)<= y3 <= (y1, y2). Także ten warunek nie został spełniony. Wiemy więc, że żaden z punktów naszych odcinków nie należy do drugiego odcinka.
Teraz możemy zbadać, czy punktu C i D znajdują się po tej samej stronie, 
czy po przeciwnych stronach odcinka |AB| oraz, czy punkty A i B leżą po tej samej, 
czy po przeciwnych stronach odcinka |CD|. Obliczamy więc wyznaczniki det(A,B,C) i det(A,B,D) by porównać ich znaki, to samo robimy z wyznacznikami det(C,D,A) i det(C,D,B). Okazuje się, że det(A,B,C)=43 a det(A,B,D)=-38, czyli wyznaczniki mają przeciwne znaki, więc punkt C i D leżą po przeciwnych stronach odcinka |AB| Również druga para wyznaczników ma przeciwne znaki: det(C,D,A)=-37, det(C,D,B)=44, punkty A i B leżą po przeciwnych stronach odcinka |CD|. Wynika z tego, że odcinki |AB| i |CD| przecinają się. 
 * 
 */
