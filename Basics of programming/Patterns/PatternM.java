/*
1. You are given a number n.
2. You've to write code to print the pattern given in output format below.
*/

import java.io.*;
import java.util.*;

public class PatternM {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0 || j == n - 1)
                    System.out.print("*");
                else if(i == j && i <= n / 2)
                    System.out.print("*");
                else if(i + j == n - 1 && i <= n / 2)
                    System.out.print("*");
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}
