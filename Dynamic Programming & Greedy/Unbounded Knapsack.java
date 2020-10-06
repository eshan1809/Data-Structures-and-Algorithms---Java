/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again and again.
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
        int[] dp = new int[tar+1];
        dp[0] = 0;
        for(int i=1;i<=tar;i++){
            int max = 0;
            for(int j=0;j<n;j++){
                if(wts[j]<=i){
                    int rc = i-wts[j];
                    int rv = dp[rc];
                    int tv = rv+vals[j];
                    if(tv>max){
                        max = tv;
                    }
                }
            }
            dp[i] = max;
        }
        System.out.print(dp[tar]);
	}
}
