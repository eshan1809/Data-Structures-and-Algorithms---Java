import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    
    public static int max(Node node) {
        if (node == null) {
            return 0;
        }
        int ml = max(node.left);
        int mr = max(node.right);
        int m = Math.max(node.data, Math.max(ml, mr));
        return m;
    }
    
    public static int min(Node node) {
        if (node == null) {
            return 0;
        }
        int ml = min(node.left);
        int mr = min(node.right);
        int m = Math.min(node.data, Math.min(ml, mr));
        return m;
    }
    
    public static boolean checkBST(Node node){
        if(node==null){
            return true;
        }
        boolean b1 = checkBST(node.left);
        boolean b2 = checkBST(node.right);
        if(node.left!=null){
            int max = max(node.left);
            if(node.data<max){
                return false;
            } else{
                return true;
            }
            
        }
        if(node.right!=null){
            int min = min(node.right);
            if(min<node.data){
                return false;
            } else{
                return true;
            }
        } 
        return b1&&b2;
    }
    
    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        int s = size(node.left) + size(node.right) + 1;
        return s;
    }
    
    public static class nodesize {
        int value;
        int size;
    }
    
    public static nodesize largestBST(Node node){
        if(node==null){
            nodesize ns = new nodesize();
            ns.size = 0;
            ns.value = -1;
            return ns;
        }
        boolean b = checkBST(node);
        if(b==true){
            nodesize ns = new nodesize();
            ns.size = size(node);
            ns.value = node.data;
            return ns;
        } else{
            nodesize nsl = largestBST(node.left);
            nodesize nsr = largestBST(node.right);
            if(nsl.size>nsr.size){
                return nsl;
            } else{
                return nsr;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        nodesize ns = largestBST(root);
        System.out.print(ns.value + "@" + ns.size);
    }
}
