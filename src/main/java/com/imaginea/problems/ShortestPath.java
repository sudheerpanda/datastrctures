package com.imaginea.problems;

import java.util.*;

/**
 * @author sudheerp
 */
class Node
{
    public int label;
    public int weight;

    public Node(int v, int w)
    {
        label = v;
        weight = w;
    }
}
 
public class ShortestPath 
{
    public static Scanner in; // for standard input
    public static int n, m; // n = #vertices, m = #edges
    public static LinkedList[] graph; // adjacency list representation
    public static int start, end; // start and end points for shortest path
 
    public static void main(String[] args) 
    {
        in = new Scanner(System.in);
 
        // Input the graph:
        System.out
                .println("Enter the number of components and wires in a circuit:");
        n = in.nextInt();
        m = in.nextInt();
 
        // Initialize adjacency list structure to empty lists:
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList();
 
        // Add each edge twice, once for each endpoint:
        System.out
                .println("Mention the wire between components and its length:");
        for (int i = 0; i < m; i++) 
        {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int w = in.nextInt();
            graph[v1].add(new Node(v2, w));
            graph[v2].add(new Node(v1, w));
        }
 
        // Input starting and ending vertices:
        System.out
                .println("Enter the start and end for which length is to be minimized: ");
        start = in.nextInt();
        end = in.nextInt();
 
        // FOR DEBUGGING ONLY:
        displayGraph();
 
        // Print shortest path from start to end:
        shortest();
    }
 
    public static void shortest() 
    {
        boolean[] done = new boolean[n];
        Node[] table = new Node[n];
        for (int i = 0; i < n; i++)
            table[i] = new Node(-1, Integer.MAX_VALUE); 
 
        table[start].weight = 0; 
 
        for (int count = 0; count < n; count++) 
        {
            int min = Integer.MAX_VALUE;
            int minNode = -1;
            for (int i = 0; i < n; i++)
                if (!done[i] && table[i].weight < min) 
                {
                    min = table[i].weight;
                    minNode = i;
                }
 
            done[minNode] = true;
 
            ListIterator iter = graph[minNode].listIterator();
            while (iter.hasNext()) 
            {
                Node nd = (Node) iter.next();
                int v = nd.label;
                int w = nd.weight;
 
                if (!done[v] && table[minNode].weight + w < table[v].weight) 
                {
                    table[v].weight = table[minNode].weight + w;
                    table[v].label = minNode;
                }
            }
        }
        for (int i = 0; i < n; i++) 
        {
            if (table[i].weight < Integer.MAX_VALUE) 
            {
                System.out.print("Wire from " + i + " to " + start
                        + " with length " + table[i].weight + ": ");
                int next = table[i].label;
                while (next >= 0) 
                {
                    System.out.print(next + " ");
                    next = table[next].label;
                }
                System.out.println();
            } else
                System.out.println("No wire from " + i + " to " + start);
        }
    }
 
    public static void displayGraph() 
    {
        for (int i = 0; i < n; i++) 
        {
            System.out.print(i + ": ");
            ListIterator nbrs = graph[i].listIterator(0);
            while (nbrs.hasNext()) 
            {
                Node nd = (Node) nbrs.next();
                System.out.print(nd.label + "(" + nd.weight + ") ");
            }
            System.out.println();
        }
    }
}