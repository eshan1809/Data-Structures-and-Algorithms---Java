/*
1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".
Note -> There can be only one celebrity. Think why?
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }
        while(st.size()!=1){
            int x1 = st.pop();
            int x2 = st.pop();
            if(arr[x1][x2]==0){
                st.push(x1);
            }
            else{
                st.push(x2);
            }
        }
        int flag = 1;
        int x = st.pop();
        for(int i=0;i<arr.length;i++){
            if(x!=i){
                if(arr[i][x]==0){
                    flag = 0;
                    break;
                }
            }
        }
        if(flag==0){
            System.out.print("none");
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[x][i]==1){
                flag = 0;
                break;
            }
        }
        if(flag==0){
            System.out.print("none");
            return;
        }
        System.out.print(x);
        return;
    }

}
