package com.brewo.huffman;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	public void serialize(HuffmanTree ht) {
		try{		 
			FileOutputStream fout = new FileOutputStream("tree");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(ht);
			oos.close();
			System.out.println("Done");
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}

}
