/*
1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34
*/


import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    long[][] dp = new long[k+1][n+1];
    for(int i=0;i<=k;i++){
        for(int j=0;j<=n;j++){
            if(i==0 || j==0 || j<i){
                dp[i][j] = 0;
            }
            else if(i==j){
                dp[i][j] = 1;
            }
            else{
                dp[i][j] = i*dp[i][j-1] + dp[i-1][j-1];
            }
        }
    }
    System.out.print(dp[k][n]);
   }
}
