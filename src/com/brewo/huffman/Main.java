package com.brewo.huffman;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
/**
 * Main class
 * 
 * @author brewczor
 *
 */
public class Main {
	
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		//m.encode();
		m.decode();
	}
	
	
	
	
	
	private void encode() throws IOException {
        Hist h = new Hist();
        FManager.read(h, "huffman.txt");
        h.sort();
        h.printHistogram();
        Huffman huffman = new Huffman(h);

        HuffmanTree huffmanTree = huffman.getHuffmanTree();
        
        Serializer s = new Serializer();
        s.serialize(huffmanTree);
        
        huffman.computeCodeMaps(huffmanTree);
        //huffmanTree.printTree();
        
        HashMap<Character, String> codeMap = huffman.getCodeMap();
        FManager.encodeBits(codeMap, "huffman.txt", "enc.txt");
        
        System.out.println("================");
        System.out.println("Encoded");
	}
	
	
	
	
	private void decode() throws IOException {
        String file = "huffman.txt";
        Hist h = new Hist();
        FManager.read(h, file);
        h.sort();
        Huffman huffman = new Huffman(h);

        //HuffmanTree huffmanTree = huffman.getHuffmanTree();
        
        
        Deserializer d = new Deserializer();
        HuffmanTree huffmanTree = d.deserialize();
        
        huffman.computeCodeMaps(huffmanTree);
        HashMap<Character, String> codeMap = huffman.getCodeMap();
        HashMap<String, Character> decodeMap = huffman.getDecodeMap();

        int offset = FManager.encodeBits(codeMap, file, "enc.txt");
        FManager.decodeBits(decodeMap, "enc.txt", "dec.txt", offset);
        
        System.out.println("================");
        System.out.println("Decoded");
	}
	
	private void read() throws IOException {
        Hist h = new Hist();
        FManager.read(h, "huffman.txt");
        
        
        h.sort();
        TreeMap<Character, Integer> tm = h.getHistogram();
        
        
        System.out.println("Size (treemap): " + tm.size());
        System.out.println("Size of the base: " + h.getBase().size());
        h.printHistogram();
	}
}
