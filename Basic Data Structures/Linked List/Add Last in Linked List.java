import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node next;
    Node(){
        this.data = 0;
        this.next = null;
    }
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size = 0;

    void addLast(int val) {
        if(size==0){
            head = new Node();
            tail = new Node();
            head.data = val;
            head.next = null;
            tail = head;
            size = 1;
            return;
        }
        Node temp = new Node();
        temp.data = val;
        temp.next = null;
        tail.next = temp;
        tail = temp;
        size++;
    }
  }

  public static void testList(LinkedList list) {
    for (Node temp = list.head; temp != null; temp = temp.next) {
      System.out.println(temp.data);
    }
    System.out.println(list.size);

    if (list.size > 0) {
      System.out.println(list.tail.data);
    } 
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addLast")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } 
      str = br.readLine();
    }

    testList(list);
  }
}
