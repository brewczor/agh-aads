package com.brewo.huffman;

import java.io.Serializable;

/**
 * Representation of HuffmanTree Node
 * 
 * @author brewczor
 *
 */
public class Node implements Serializable{

    private char c;
    private int occurrences;
    private Node leftChild;
    private Node rightChild;

    public Node() {}

    public Node(char c, int occurrences) {
        this.occurrences = occurrences;
        this.c = c;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}
