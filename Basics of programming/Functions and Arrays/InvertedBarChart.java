/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print an inverted bar chart representing value of arr a.
*/

import java.util.*;

public class InvertedBarChart {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), max = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
        }
        scn.close();
        while(max-- > 0){
            for(int i = 0; i < n; i++){
                if(arr[i] > 0){
                    System.out.print("*");
                    arr[i]--;
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}
