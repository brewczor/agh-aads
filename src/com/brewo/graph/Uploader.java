package com.brewo.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Uploader<N, E> {
	
	public static void main(String[] args) throws IOException {
		Uploader u = new Uploader();
		Graph g = u.getGraph("data.txt");
		
			
		Dijkstra d = new Dijkstra(g, "1");
		
		d.run();
	}

	public Graph getGraph(String filePath) throws IOException {
		//List<Point> resultList = new LinkedList<Point>();

		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String textLine = bufferedReader.readLine();
		String[] splitted;
		
		Graph g = new MatrixGraph<>();
		//Graph g = new ListGraph<>();
		do {
			splitted = textLine.split("\t");
			System.out.println("|" + splitted[0] + "|" + splitted[1] + "|" + splitted[2]);

			g.addEdge(splitted[2], splitted[0], splitted[1],Double.parseDouble(splitted[2]));

			textLine = bufferedReader.readLine();
		} while (textLine != null);

		bufferedReader.close();

//		System.out.println("pointList size: " + resultList.size());
//		for(int i = 0; i < resultList.size(); i++) {
//			System.out.println("P: " + ((MyPoint)resultList.get(i)).getIndex() + "/"+ resultList.get(i).getX() + "/" 
//						+ resultList.get(i).getY());
//		}

		return g;
	}
}
