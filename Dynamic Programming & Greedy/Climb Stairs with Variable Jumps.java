/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=n-1;i>=0;i--){
            arr[i] = scn.nextInt();
        }
        int ans = climbStairs(n,arr,new int[n+1]);
        System.out.print(ans);
    }
    
    public static int climbStairs(int n, int[] a, int[] qb){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int ans = 0;
        for(int i=1;i<=a[n-1];i++){
            ans+= climbStairs(n-i,a,qb);
        }
        qb[n] = ans;
        return ans;
    }

}
