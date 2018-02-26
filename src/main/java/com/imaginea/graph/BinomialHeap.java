package com.imaginea.graph;


class BinomialHeapNode{

    int key,degree;
    BinomialHeapNode parent;
    BinomialHeapNode sibling;
    BinomialHeapNode child;
    public BinomialHeapNode(int k){
        key=k;
        degree=0;
        parent=null;
        sibling=null;
        child=null;
    }

    public int getSize(){
        return (1+((child==null)?0:child.getSize()) +((sibling==null)?0:sibling.getSize()));
    }

}public class BinomialHeap {

}
