import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp=n/2,no=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            int start=no;
            for(int j=1;j<=2*no-1;j++){
                System.out.print(start + "\t");
                if(j<=(2*no-1)/2){
                    start++;
                }
                else{
                    start--;
                }
            }
            System.out.println();
            if(i<=n/2){
                sp--;
                no++;
            }
            else{
                sp++;
                no--;
            }
        }
    }
}
