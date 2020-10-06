/*
1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
*/


import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    long n = scn.nextInt();
    long e0 = 1;
    long e1 = 1;
    for(long i=1;i<n;i++){
        long ne0 = e1;
        long ne1 = e0+e1;
        e0=ne0;
        e1=ne1;  
    }
    long ans = e0+e1;
    ans = ans*ans;
    System.out.print(ans);
 }

}
