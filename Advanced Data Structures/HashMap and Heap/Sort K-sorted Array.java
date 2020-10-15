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
      for(int i:arr){
          pq.add(i);
      }
      for(int i=0;i<n;i++){
          int a = pq.peek();
          pq.remove();
          arr[i] = a;
          System.out.println(arr[i]);
      }
   }
}
