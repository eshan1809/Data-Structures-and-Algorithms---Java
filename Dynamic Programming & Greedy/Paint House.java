/*
1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] ans = new int[3][n];
        for(int i=0;i<3;i++){
            ans[i][0] = arr[0][i];
        }
        
        for(int j=1;j<n;j++){
            for(int i=0;i<3;i++){
                if(i==0){
                    ans[i][j] = Math.min(ans[i+1][j-1],ans[i+2][j-1]) + arr[j][i];
                }
                else if(i==1){
                    ans[i][j] = Math.min(ans[i-1][j-1],ans[i+1][j-1]) + arr[j][i];
                }
                else if(i==2){
                    ans[i][j] = Math.min(ans[i-1][j-1],ans[i-2][j-1]) + arr[j][i];
                }
            }
        }
        int m = Math.min(Math.min(ans[0][n-1],ans[1][n-1]),ans[2][n-1]);
        System.out.print(m);
    }
}
