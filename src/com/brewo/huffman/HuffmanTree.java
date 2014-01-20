package com.brewo.huffman;

import java.io.Serializable;

/**
 * HuffmanTree implementation
 * 
 * @author brewczor
 *
 */
public class HuffmanTree implements Serializable{

    private Node root;

    public void printTree() {
        this.printTree(0, root);
    }

    private void printTree(int level, Node n) {
        System.out.println("Lvl: " + level + "|Char: " + n.getC() + "|Occ:" + n.getOccurrences());
        
        if (n.getRightChild() != null) {
            printTree(level + 1, n.getRightChild());
        }
        
        if (n.getLeftChild() != null) {
            printTree(level + 1, n.getLeftChild());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

