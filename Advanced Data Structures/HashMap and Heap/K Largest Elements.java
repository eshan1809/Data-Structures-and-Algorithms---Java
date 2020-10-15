import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int v:arr){
          pq.add(v);
      }
      int i=0;
      while(arr.length-k>i){
        pq.remove();
        i++;
      }
      while(k!=0){
          int x = pq.peek();
          pq.remove();
          System.out.println(x);
          k--;
      }
    }

}
