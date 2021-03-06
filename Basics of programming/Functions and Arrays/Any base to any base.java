import java.util.*;
  
 public class Main{
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int y=getValueIndecimal(n,sourceBase);
        int x=getValueInBase(y,destBase);
        System.out.print(x);
   }   
   public static int getValueIndecimal(int n, int b){
        int sum=0,i=0;
        while(n>0){
            sum+=(n%10)*Math.pow(b,i);
            i++;
            n=n/10;
        }
        return sum;
    }
    
    public static int getValueInBase(int n, int b){
        int sum=0,i=1;
        while(n>0){
            sum+=(n%b)*i;
            i*=10;
            n/=b;
        }
        return sum;
   }
  }
