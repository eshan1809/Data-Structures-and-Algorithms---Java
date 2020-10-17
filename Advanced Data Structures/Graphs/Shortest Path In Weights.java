/*
1. You are given a graph and a source vertex. The vertices represent cities and the edges represent 
    distance in kms.
2. You are required to find the shortest path to each city (in terms of kms) from the source city along 
    with the total distance on path from source to destinations.
*/


import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wsf;
        Pair(int v, String psf, int wsf){
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf-o.wsf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        // write your code here
        boolean[] visited = new boolean[vtces];
        DijkstraPath(graph, src, visited);
    }

    public static void DijkstraPath(ArrayList < Edge > [] graph, int src, boolean[] visited){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src+"", 0));
        while(pq.size()>0){
            Pair rem = pq.remove();
            if(visited[rem.v]==false){
                visited[rem.v] = true;
                System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
                for(Edge e:graph[rem.v]){
                    if(visited[e.nbr]==false){
                        pq.add(new Pair(e.nbr, rem.psf+e.nbr, rem.wsf+e.wt));
                    }
                }
            }
        }
    }
}
