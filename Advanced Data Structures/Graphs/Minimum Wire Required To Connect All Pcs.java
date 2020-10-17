/*
1. You are given a graph and a source vertex. The vertices represent computers and the edges represent length of LAN wire required to connect them.
2. You are required to find the minimum length of wire required to connect all PCs over a network. 
Print the output in terms of which all PCs need to be connected, and the length of wire between them.
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
        int s;
        int wt;
        Pair(int v, int s, int wt){
            this.v = v;
            this.s = s;
            this.wt = wt;
        }
        public int compareTo(Pair o){
            return this.wt - o.wt;
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

        // write your code here
        boolean[] visited = new boolean[vtces];
        PrimsAlgo(graph,visited);
    }
    
    public static void PrimsAlgo(ArrayList < Edge > [] graph, boolean[] visited){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        while(pq.size()>0){
            Pair rem = pq.remove();
            if(visited[rem.v]==false){
                visited[rem.v] = true;
                if(rem.s != -1){
                    System.out.println("[" + rem.v + "-" + rem.s + "@" + rem.wt + "]");
                }
                for(Edge e:graph[rem.v]){
                    if(visited[e.nbr]==false){
                        pq.add(new Pair(e.nbr, rem.v , e.wt));
                    }
                }
            }
        }  
    }
}
