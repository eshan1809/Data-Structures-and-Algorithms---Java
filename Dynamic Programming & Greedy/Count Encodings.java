/*
1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. You are required to calculate and print the count of encodings for the string str.
     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic 
     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
     For 103 -> there is 1 encoding. jc
     For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
     print 0.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int[] dp = new int[str.length()];
        for(int i=0;i<dp.length;i++){
            char ch = str.charAt(i);
            if(i==0){
                if(ch=='0'){
                    System.out.println(0);
                    return;
                }
                dp[0] = 1;
            } else if(i==1){
                String s = str.substring(0,2);
                int sv = Integer.parseInt(s);
                if(ch=='0' && sv>26){
                    System.out.println(0);
                    return;
                } else if(ch=='0' || sv>26){
                    dp[1] = 1;
                } else{
                    dp[1] = 2;
                }
            } else{
                String s = str.substring(i-1,i+1);
                int sv = Integer.parseInt(s);
                if(ch=='0' && sv>26){
                    System.out.println(0);
                    return;
                } else if(ch=='0'){
                    dp[i] = dp[i-2];
                }else if(sv>26){
                    dp[i] = dp[i-1];
                } else{
                    dp[i] = dp[i-1]+dp[i-2];
                }
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}
