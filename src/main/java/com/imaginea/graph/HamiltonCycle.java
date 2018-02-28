package com.imaginea.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hamiltonian cycle is a path in a graph that visits each vertex exactly once
 * and back to starting vertex.
 * @author sudheerp
 */
public class HamiltonCycle {
    private int V, pathCount;
    private int[] path;
    private int[][] graph;

    public void findHamiltonianCycle(int[][] g)
    {
        V = g.length;
        path = new int[V];

        Arrays.fill(path, -1);
        graph = g;
        try
        {
            path[0] = 0;
            pathCount = 1;
            solve(0);
            System.out.println("No solution");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            display();
        }
    }
    public void solve(int vertex) throws Exception
    {
        /** solution **/
        if (graph[vertex][0] == 1 && pathCount == V)
            throw new Exception("Solution found");
        /** all vertices selected but last vertex not linked to 0 **/
        if (pathCount == V)
            return;

        for (int v = 0; v < V; v++)
        {
            /** if connected **/
            if (graph[vertex][v] == 1 )
            {
                /** add to path **/
                path[pathCount++] = v;
                /** remove connection **/
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;

                /** if vertex not already selected  solve recursively **/
                if (!isPresent(v))
                    solve(v);

                /** restore connection **/
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                /** remove path **/
                path[--pathCount] = -1;
            }
        }
    }

    public boolean isPresent(int v)
    {
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v)
                return true;
        return false;
    }

    public void display()
    {
        System.out.print("\nPath : ");
        for (int i = 0; i <= V; i++)
            System.out.print(path[i % V] +" ");
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HamiltonCycle hamiltonCycle = new HamiltonCycle();
        System.out.println("Enter the  number of vertices");
        int V=sc.nextInt();
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();

        hamiltonCycle.findHamiltonianCycle(graph);
    }
}
