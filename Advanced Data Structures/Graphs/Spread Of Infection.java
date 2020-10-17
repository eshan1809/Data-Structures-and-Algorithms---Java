/*
1. You are given a graph, representing people and their connectivity.
2. You are also given a src person (who got infected) and time t.
3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.
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

    static class Pair {
        int v;
        int t;
        Pair(int v, int t) {
            this.v = v;
            this.t = t;
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
        int t = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];
        int c = countInfectedPersons(graph,src,t,visited);
        System.out.println(c);
    }

    public static int countInfectedPersons(ArrayList < Edge > [] graph, int src, int t, boolean[] visited){
        Queue<Pair> q = new ArrayDeque<>();
        int count = 0;
        q.add(new Pair(src,1));
        count++;
        while(q.size()>0){
            Pair rem = q.remove();
            if(rem.t>t){
                count = count - q.size() - 1;
                return count;
            }
            if(visited[rem.v] == true){
                count--;
            } else{
                visited[rem.v] = true;
                for(Edge e:graph[rem.v]){
                    if(visited[e.nbr]==false){
                        q.add(new Pair(e.nbr, rem.t+1));
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
