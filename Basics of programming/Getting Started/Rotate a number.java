import java.util.*;
   
    public class Main{
   
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int temp=n,count=0,m;
        while(temp>0){
            count++;
            temp=temp/10;
        }
        r=r%count;
        if(r>0){
            m=n%((int)Math.pow(10,r));
            n=n/((int)Math.pow(10,r));
            m=m*((int)Math.pow(10,count-r));
            System.out.print(m+n);
        }
        else if(r<0){
            m=n%((int)Math.pow(10,count+r));
            n=n/((int)Math.pow(10,count+r));
            m=m*((int)Math.pow(10,-r));
            System.out.print(m+n);
        }
        else{
            System.out.print(n);
        }
    }
   }
