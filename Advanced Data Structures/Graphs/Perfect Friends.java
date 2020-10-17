/*
1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<k;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        ArrayList<Integer> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTree(graph,i,comp,visited);
                comps.add(comp.size());
            }
        }
        int sum = 0;
        if(comps.size()==2){
            for(int i=1;i<comps.size();i++){
                sum += comps.get(i-1)*comps.get(i);
            }
        } else if(comps.size()>2){
            for(int i=1;i<comps.size();i++){
                sum += comps.get(i-1)*comps.get(i);
            }
            sum += comps.get(0)*comps.get(comps.size()-1);
        }
        System.out.println(sum);
    }
    
    public static void drawTree(ArrayList<Integer>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for(int e:graph[src]){
            if(visited[e]==false){
                drawTree(graph,e,comp,visited);
            }
        }
    }  
}
