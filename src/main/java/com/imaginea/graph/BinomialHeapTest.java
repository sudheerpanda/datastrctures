package com.imaginea.graph;

/**
 * @author sudheerp
 */
public class BinomialHeapTest {
    public static void main(String[] args) {
        BinomialHeap bh=new BinomialHeap();
        bh.insert(1);
        bh.insert(4);
        bh.insert(2);
        bh.insert(14);
        bh.displayHeap();
    }
}
