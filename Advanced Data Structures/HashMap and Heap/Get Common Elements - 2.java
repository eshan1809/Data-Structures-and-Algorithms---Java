import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = scn.nextInt();
            if(hm1.containsKey(x)){
                int f = hm1.get(x);
                hm1.put(x,f+1);
            } else{
                hm1.put(x,1);
            }
        }
        n = scn.nextInt();
        for(int i=0;i<n;i++){
            int x = scn.nextInt();
            if(hm1.containsKey(x)){
                int z = hm1.get(x);
                if(z>0){
                    System.out.println(x);
                    hm1.put(x,z-1);
                }
            }
        }
    }
}
