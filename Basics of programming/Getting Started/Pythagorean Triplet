import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int c = scn.nextInt();
    int flag = 0;
    if(a>b && a>c){
        if(b*b + c*c == a*a){
            flag = 1;
        }
    }
    else if(b>a && b>c){
        if(b*b == c*c + a*a){
            flag = 1;
        }
    }
    else if(c>a && c>b){
        if(b*b + a*a == c*c){
            flag = 1;
        }
    }
    if(flag==1){
        System.out.print("true");
    }
    else{
        System.out.print("false");
    }
   }
  }
