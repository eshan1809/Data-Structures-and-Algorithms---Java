/*
1. You are given a 2d array where 0's represent land and 1's represent water. 
     Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 0 && visited[i][j] == false){
                    drawCC(arr,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
    public static void drawCC(int[][] arr, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == true || arr[i][j] == 1){
            return;
        }
        visited[i][j] = true;
        drawCC(arr,i-1,j,visited);
        drawCC(arr,i,j+1,visited);
        drawCC(arr,i+1,j,visited);
        drawCC(arr,i,j-1,visited);
    }
}
