/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
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
        int pist=0,pibt=0,lsf=arr[0],msf=arr[n-1],sum=0;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 0;
        dp2[n-1] = 0;
        for(int i=1;i<n;i++){
            if(arr[i]<lsf){
                lsf=arr[i];
            }
            pist=arr[i]-lsf;
            if(pist>dp1[i-1]){
                dp1[i] = pist;
            }
            else{
                dp1[i] = dp1[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>msf){
                msf=arr[i];
            }
            pibt = msf-arr[i];
            if(pibt>dp2[i+1]){
                dp2[i] = pibt;
            }
            else{
                dp2[i] = dp2[i+1];
            }
        }
        for(int i=0;i<n;i++){
            if(dp1[i]+dp2[i]>sum){
                sum = dp1[i]+dp2[i];
            }
        }
        System.out.print(sum);
    }
}
