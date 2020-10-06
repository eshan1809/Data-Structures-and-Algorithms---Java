/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];
        for(int i=0;i<n;i++){
            vals[i] = scn.nextInt();
        }
        for(int i=0;i<n;i++){
            wts[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int[][] dp = new int[n+1][tar+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=tar;j++){
                if(j>=wts[i-1]){
                    if(dp[i-1][j-wts[i-1]]+vals[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][j-wts[i-1]]+vals[i-1];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.print(dp[n][tar]);
    }
}
