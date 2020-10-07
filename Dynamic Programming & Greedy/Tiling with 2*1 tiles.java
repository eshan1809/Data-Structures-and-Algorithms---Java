/*
1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i1=1,i2=1;
        for(int i=1;i<n;i++){
            int temp=i2;
            i2=i1+i2;
            i1=temp;
        }
        System.out.print(i2);
    }
}
