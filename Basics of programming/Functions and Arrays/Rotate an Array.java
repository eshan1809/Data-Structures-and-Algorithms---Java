import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k){
    int n=a.length;
    k=k%n;
    if(k>=0){
        for(int j=0;j<k;j++){
            int temp=a[n-1];
            for(int i=n-1;i>0;i--){
                a[i]=a[i-1];
            }
            a[0]=temp;
        }
    }
    else{
        k=k*(-1);
        for(int j=0;j<k;j++){
            int temp=a[0];
            for(int i=0;i<n-1;i++){
                a[i]=a[i+1];
            }
            a[n-1]=temp;
        }
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }
}
