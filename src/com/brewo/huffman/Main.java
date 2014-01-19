package com.brewo.huffman;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		//m.encode();
		m.decode();
	}
	
	private void read() throws IOException {
        Histogram h = new Histogram();
        FileManager.read(h, "huffman.txt");
        h.sort();
        TreeMap<Character, Integer> tm = h.getHistogram();
        System.out.println("Tree map size: " + tm.size());
        System.out.println("Base size: " + h.getBase().size());
        h.printHistogram();
	}
	
	private void encode() throws IOException {
        Histogram h = new Histogram();
        FileManager.read(h, "huffman.txt");
        h.sort();
        Huffman huffman = new Huffman(h);

        HuffmanTree huffmanTree = huffman.getHuffmanTree();
        huffman.computeCodeMaps(huffmanTree);
        huffmanTree.printTree();
        HashMap<Character, String> codeMap = huffman.getCodeMap();
        FileManager.encodeBits(codeMap, "huffman.txt", "encoded.txt");
	}
	
	private void decode() throws IOException {
        String file = "huffman.txt";
        Histogram h = new Histogram();
        FileManager.read(h, file);
        h.sort();
        Huffman huffman = new Huffman(h);

        HuffmanTree huffmanTree = huffman.getHuffmanTree();
        huffman.computeCodeMaps(huffmanTree);
        HashMap<Character, String> codeMap = huffman.getCodeMap();
        HashMap<String, Character> decodeMap = huffman.getDecodeMap();

        int offset = FileManager.encodeBits(codeMap, file, "encoded.txt");
        FileManager.decodeBits(decodeMap, "encoded.txt", "decoded.txt", offset);
	}
}
