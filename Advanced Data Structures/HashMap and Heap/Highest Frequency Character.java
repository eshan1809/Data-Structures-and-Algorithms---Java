import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int of = hm.get(ch);
                hm.put(ch,of+1);
            } else{
                hm.put(ch,1);
            }
        }
        char max = str.charAt(0);
        for(Character ch:hm.keySet()){
            if(hm.get(ch) > hm.get(max)){
                max = ch;
            }
        }
        System.out.print(max);
    }
}
