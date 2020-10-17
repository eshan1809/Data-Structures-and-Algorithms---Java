/*
1. You are given a graph, and a source vertex.
2. You are required to do a iterative depth first traversal and print which vertex is reached via which path, starting from the source.
Note -> Iterative depth first traversal should mimic "Reverse preorder" i.e. nbr with highest value should be visited first and should be printed on the way down in recursion.
*/


import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair{
        int v;
        String psf;
        Pair(int v, String psf){
            this.v = v;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(src, src + ""));
        while(s.size()>0){
            Pair rem = s.pop();
            if(visited[rem.v] == false){
                visited[rem.v] = true;
                System.out.println(rem.v + "@" + rem.psf);
                for(Edge e:graph[rem.v]){
                    if(visited[e.nbr]==false){
                        s.push(new Pair(e.nbr, rem.psf+e.nbr));
                    }
                }
                  
            }
        }
    }
}
