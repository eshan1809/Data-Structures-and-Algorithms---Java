/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int t = scn.nextInt();
        int[][] dp = new int[t+1][n];
        for(int i=1;i<=t;i++){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<n;j++){
                if(dp[i-1][j-1]-arr[j-1]>max){
                    max = dp[i-1][j-1]-arr[j-1];
                } 
                if(max+arr[j]>dp[i][j-1]){
                    dp[i][j] = max+arr[j];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        System.out.print(dp[t][n-1]);
    }

}
