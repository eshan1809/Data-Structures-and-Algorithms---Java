/*
1. You are given a number following certain constraints.
2. The key constraint is if the number is 5 digits long, it'll contain all the digits from 1 to 5 without missing any and without repeating any. e.g. 23415 is a 5 digit long number containing all digits from 1 to 5 without missing and repeating any digit from 1 to 5.Take a look at few other valid numbers - 624135, 81456273 etc.Here are a few invalid numbers - 139, 7421357 etc.
3. The inverse of a number is defined as the number created by interchanging the face value (from left to right) and index of digits of number.e.g. for 526134 (reading from left to right, 5 is in place 1, 2 is in place 2, 6 is in place 3, 1 is in place 4, 3 is in place 5 and 4 is in place 6), the inverse will be 425613 (reading from left to right, 4 is in place 1, 2 is in place 2, 5 is in place 3, 6 is in place 4, 1 is in place 5 and 3 is in place 6) More examples - inverse of 2134 is 2134 and inverse of 24153 is 31524.    
4. Take as input number "n", assume that the number will follow constraints.
5. Print it's inverse - left to right.
*/

import java.util.*;
import java.io.*;

public class InverseOfANumber {
    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = str.length();
        int[] arr = new int[n + 1];
        for(int i = 0; i < n; i++)
            arr[str.charAt(i) - '0'] = i + 1;
        for(int i = 1; i <= n; i++)
            System.out.print(arr[i]);
        scn.close();
    }
}
