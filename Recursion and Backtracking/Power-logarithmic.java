import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int p = power(x,n);
        System.out.print(p);
    }

    public static int power(int x, int n){
        
        if(x==1){
            return 1;
        }
        if(n==0){
            return 1;
        }
        else{
            if(n%2==0){
                return power(x,n/2)*power(x,n/2);
            }
            else{
                return x*power(x,n/2)*power(x,n/2);
            }
        }
    }

}
