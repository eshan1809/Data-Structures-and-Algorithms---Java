import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = scn.nextInt();
            hm.put(x,0);
        }
        n = scn.nextInt();
        for(int i=0;i<n;i++){
            int x = scn.nextInt();
            if(hm.containsKey(x)){
                System.out.println(x);
                hm.remove(x);
            }
        }
    }
}
