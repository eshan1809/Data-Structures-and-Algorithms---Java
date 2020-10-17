/*
1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.
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
        
        boolean[] visited = new boolean[vtces];
        printHamiltonian(graph, src, src, visited, src + "", 1);
        
    }

    public static void printHamiltonian(ArrayList<Edge>[] graph, int src, int s1, boolean[] visited, String psf, int count) {
        if (count == graph.length){
            for(Edge edge: graph[src]){
                if(edge.nbr==s1){
                    System.out.println(psf + "*");
                    return;
                }
            }
            System.out.println(psf + ".");
            return;
        }
        visited[src] = true;
        count++;
        for (Edge edge: graph[src]) {
            if (visited[edge.nbr] == false) {
                printHamiltonian(graph, edge.nbr, s1, visited, psf + edge.nbr, count);
            }
        }
        visited[src] = false;
        count--;
    }
}
