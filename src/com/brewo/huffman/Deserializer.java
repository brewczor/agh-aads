package com.brewo.huffman;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializer{
	   public HuffmanTree deserialize(){
	 
		   HuffmanTree hf;
	 
		   try{
	 
			   FileInputStream fin = new FileInputStream("tree");
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   hf = (HuffmanTree) ois.readObject();
			   ois.close();
	 
			   return hf;
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	   } 
	}
