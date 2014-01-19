package com.brewo.huff;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//tablice czestotliwosci
//wrzucamy czestotliwosci na liste
//mapa jest spoko
public class Huffman {

	public static void main(String[] args) throws IOException {
		Huffman h = new Huffman();

		Map<Character, Integer> letterMap = h.createMap("huffman.txt");

		for (char ch : letterMap.keySet()) {
			System.out.println(ch + ":" + letterMap.get(ch));
		}
	}

	private Map sortMap(Map inputMap) {
		Map<Character, Integer> resultMap = new HashMap<Character, Integer>();

		int min = Integer.MAX_VALUE;
		char tmpCh;
		while (resultMap.size() != 0) {
			for (char ch : resultMap.keySet()) {

			}

			min = Integer.MAX_VALUE;
		}

		return resultMap;
	}

	public Map<Character, Integer> createMap(String filePath)
			throws IOException {
		Map<Character, Integer> resultMap = new HashMap<Character, Integer>();

		FileReader fileReader = new FileReader(filePath);

		int r;
		int charCount = 0;
		while ((r = fileReader.read()) != -1) {
			char ch = (char) r;
			if (resultMap.containsKey(ch)) {
				charCount = resultMap.get(ch);
				++charCount;
				resultMap.put(ch, charCount);
			} else {
				resultMap.put(ch, 1);
			}
		}

		fileReader.close();

		return resultMap;
	}

}
