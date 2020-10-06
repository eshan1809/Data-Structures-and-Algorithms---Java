import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int ans = fabonacciAt(n);
    System.out.print(ans);
}

public static int fabonacciAt(int n){
    if(n==0 || n==1){
        return n;
    }
    int x1 = fabonacciAt(n-1);
    int x2 = fabonacciAt(n-2);
    int ans = x1 + x2;
    return ans;
}
}
