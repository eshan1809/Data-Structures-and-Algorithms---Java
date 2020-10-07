/*
1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two fences have same colors.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] ans = new int[2][n];
        ans[0][1] = m;
        ans[1][1] = m*(m-1);
        for(int i=2;i<n;i++){
            ans[0][i] = ans[1][i-1];
            ans[1][i] = (ans[1][i-1]+ans[0][i-1])*(m-1);
        }
        int x = ans[0][n-1]+ans[1][n-1];
        System.out.print(x);
    }
}
