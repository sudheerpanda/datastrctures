package com.imaginea.heap;

import java.util.*;


class SkewNode {
    int element;
    SkewNode left, right;

    public SkewNode(int val) {
        this.element = val;
        this.left = null;
        this.right = null;
    }
}

class SkewHeap {
    private SkewNode root;
    private int size;


    public SkewHeap() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * clear
     **/
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Function to get size
     **/
    public int getSize() {
        return size;
    }

    /**
     * insert
     **/
    public void insert(int val) {
        root = merge(root, new SkewNode(val));
        size++;
    }

    public void remove() {
        if (root == null)
            throw new NoSuchElementException("Element not found");
        root = merge(root.left, root.right);
        size--;
    }

    /**
     * merge
     **/
    private SkewNode merge(SkewNode x, SkewNode y) {
        if (x == null)
            return y;
        if (y == null)
            return x;

        if (x.element < y.element) {
            SkewNode temp = x.left;
            x.left = merge(x.right, y);
            x.right = temp;
            return x;
        } else {
            SkewNode temp = y.right;
            y.right = merge(y.left, x);
            y.left = temp;
            return y;
        }
    }

    public void displayHeap() {
        System.out.print("\nHeap : ");
        displayHeap(root);
        System.out.println("\n");
    }

    private void displayHeap(SkewNode r) {
        if (r != null) {
            displayHeap(r.left);
            System.out.print(r.element + " ");
            displayHeap(r.right);
        }
    }
}

public class SkewHeapTest {
    public static void main(String[] args) {
        SkewHeap sh = new SkewHeap();
        sh.insert(1);
        sh.insert(10);
        sh.insert(0);
        sh.insert(5);
        sh.displayHeap();


    }
}