/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int path = climbStairs(n,new int[n+1]);
        System.out.print(path);
    }
    
    public static int climbStairs(int n, int[] qb){
        if(n<0){
            return 0;
        }
        else if(n==0){
            return 1;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int path1 = climbStairs(n-1, qb);
        int path2 = climbStairs(n-2, qb);
        int path3 = climbStairs(n-3, qb);
        qb[n]=path1+path2+path3;
        return qb[n];
    }
}
