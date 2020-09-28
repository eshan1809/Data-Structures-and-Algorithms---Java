import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        for(int i = low;i <= high;i++){
            int flag=0;
            for(int k=2;k*k<=i;k++){
                if(i%k==0){
                    flag++;
                    break;
                }
            }
            if(flag==0){
                System.out.println(i);
            }
        }
    }
}
