import java.io.*;
import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair> {
        int li,di,dv;
        Pair(int li, int di, int dv){
            this.li = li;
            this.di = di;
            this.dv = dv;
        }
        public int compareTo(Pair o){
            return this.dv-o.dv;
        }
    }
    public static ArrayList < Integer > mergeKSortedLists(ArrayList < ArrayList < Integer >> lists) {
        ArrayList < Integer > rv = new ArrayList < > ();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<lists.size();i++){
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }
        while(pq.size()>0){
            Pair rem = pq.remove();
            rv.add(rem.dv);
            if(rem.di < lists.get(rem.li).size()-1){
                pq.add(new Pair(rem.li, rem.di+1, lists.get(rem.li).get(rem.di+1)));
            }
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList < ArrayList < Integer >> lists = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ArrayList < Integer > list = new ArrayList < > ();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList < Integer > mlist = mergeKSortedLists(lists);
        for (int val: mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
