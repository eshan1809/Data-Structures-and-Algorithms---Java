import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int l = n<m?n:m;
        int gcd=1;
        for(int i=1;i<=l;i++){
            if(n%i==0 && m%i==0){
                gcd=i;
            }
        }
        int lcm = n*m/gcd;
        System.out.print(gcd + "\n" + lcm);
    }
    }
