import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int f = scn.nextInt();
        System.out.println(lastIndex(arr,f));
    }

    public static int lastIndex(int[] arr, int x){
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
}
