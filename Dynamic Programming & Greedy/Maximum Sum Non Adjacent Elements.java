/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int[][] ans = new int[2][n];
        ans[0][0] = arr[0];
        ans[1][0] = 0;
        for(int i=1;i<n;i++){
            ans[0][i] = ans[1][i-1]+arr[i];
            ans[1][i] = Math.max(ans[0][i-1],ans[1][i-1]);
        }
        System.out.print(Math.max(ans[0][n-1],ans[1][n-1]));
    }
}
