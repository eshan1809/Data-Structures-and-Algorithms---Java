/*
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
*/


import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int e0 = 1;
    int e1 = 1;
    for(int i=1;i<n;i++){
        int temp=e0;
        e0=e1;
        e1=e1+temp;
        
    }
    System.out.print(e0 +e1);
 }

}
