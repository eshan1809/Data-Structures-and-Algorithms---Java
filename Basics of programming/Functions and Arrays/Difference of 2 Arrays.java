import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] a1 = new int[n1];
    for(int i=0;i<n1;i++){
        a1[i]=scn.nextInt();
    }
    int n2 = scn.nextInt();
    int[] a2 = new int[n2];
    for(int i=0;i<n2;i++){
        a2[i]=scn.nextInt();
    }
    int[] d = new int[n2];
    int i=n1-1,j=n2-1,k=n2-1,c=0;
    while(k>=0){
        int av = i>=0?a1[i]:0;
        if(a2[j]+c >= av){
            d[k]=c+a2[j]-av;
            c=0;
        }
        else{
            d[k]=c+10+a2[j]-av;
            c=-1;
        }
        i--;
        j--;
        k--;
    }
    int idx=0;
    while(idx<n2){
        if(d[idx]==0){
            idx++;
        }
        else{
            break;
        }
    }
    while(idx<n2){
        System.out.println(d[idx]);
        idx++;
    }
 }

}
