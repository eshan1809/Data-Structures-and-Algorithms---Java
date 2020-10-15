import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = scn.nextInt();
            if(!hm.containsKey(x)){
                hm.put(x,true);
            }
        }
        for(int i:hm.keySet()){
            if(hm.containsKey(i-1)){
                hm.put(i,false);
            }
        }
        int length = 0;
        int start = 0;
        for(int i:hm.keySet()){
            if(hm.get(i)){
                int x = i;
                while(hm.containsKey(x+1)){
                    x++;
                }
                if(x-i>length){
                    start = i;
                    length = x - i;
                }
            }
        }
        for(int i=start;i<=start+length;i++){
            System.out.println(i);
        }
    }
}
