import java.util.*;

public class PatternInvertedHourGlass {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        // write ur code here
        int n = scn.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || i == n - 1)
                    System.out.print("*");
                else if(i == j || i + j == n - 1)
                    System.out.print("*");
                else if(i < n / 2 && j > i &&  j < n - i - 1)
                    System.out.print("*");
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
