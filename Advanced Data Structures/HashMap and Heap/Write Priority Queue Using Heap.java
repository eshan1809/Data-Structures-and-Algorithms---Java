import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList < Integer > data;

        public PriorityQueue() {
            data = new ArrayList < > ();
        }

        public void add(int val) {
            data.add(val);
        }

        public int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            int idx = 0;
            int min = data.get(0);
            for(int i=1;i<data.size();i++){
                if(data.get(i)<min){
                    min = data.get(i);
                    idx = i;
                }
            }
            data.remove(idx);
            return min;
        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            int min = data.get(0);
            for(int i:data){
                if(i<min){
                    min=i;
                }
            }
            return min;
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
