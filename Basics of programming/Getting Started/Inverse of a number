import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int temp = n,count=0;
    while(temp>0){
        count++;
        temp=temp/10;
    }
    int m=0;
    for(int i=1;i<=count;i++){
        int k=n%10;
        m+=i*(int)Math.pow(10,k-1);
        n=n/10;
    }
    System.out.print(m);
 }
}
