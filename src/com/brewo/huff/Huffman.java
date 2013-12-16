package com.brewo.huff;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import sun.reflect.generics.tree.Tree;

//tablice czestotliwosci
//wrzucamy czestotliwosci na liste
//mapa jest spoko
public class Huffman {

	public static void main(String[] args) throws IOException {
		Huffman h = new Huffman();
		
		Map<Character, Integer> letterMap = h.createMap("big.txt");
		
		for(char ch : letterMap.keySet()) {
			System.out.println(ch + ":" + letterMap.get(ch));
		}
	}
	
	private Map sortMap(Map inputMap) {
		Map<Character, Integer> resultMap = new HashMap<Character, Integer>();
		
		int min = Integer.MAX_VALUE;
		char tmpCh;
		while(resultMap.size() != 0) {
			for(char ch : resultMap.keySet()) {
				 
			}
			
			min = Integer.MAX_VALUE;
		}
		
		return resultMap;
	}
	
	
	public Map createMap(String filePath) throws IOException {
		//List<Point> resultList = new LinkedList<Point>();

		Map<Character, Integer> resultMap = new HashMap<Character, Integer>();
		
		FileReader fileReader = new FileReader(filePath);
	
		int r;
        while ((r = fileReader.read()) != -1) {
            char ch = (char) r;
            
            if(resultMap.containsKey(ch)) {
            	int x = resultMap.get(ch);
            	++x;
            	resultMap.put(ch, x);
            } else {
            	resultMap.put(ch, 1);
            }
            //System.out.println("Do something with " + bt);
        }
      
        return resultMap;


	}
	
	
	

}
