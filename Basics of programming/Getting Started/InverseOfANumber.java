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
    }
}
