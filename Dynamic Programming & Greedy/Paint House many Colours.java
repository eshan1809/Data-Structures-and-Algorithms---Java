/*
1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] ans = new int[n][m];
        for(int i=0;i<m;i++){
            ans[0][i] = arr[0][i];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int min=Integer.MAX_VALUE;
                for(int k=0;k<m;k++){
                    if(k!=j){
                        if(ans[i-1][k]<min){
                            min=ans[i-1][k];
                        }
                    }
                }
                ans[i][j] = min + arr[i][j];
            }
        }
        int mi=Integer.MAX_VALUE;
        for(int k=0;k<m;k++){
            if(ans[n-1][k]<mi){
                mi=ans[n-1][k];
            }
        }
        System.out.print(mi);
    }
}
