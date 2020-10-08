/*
1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
*/


import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack < String > post = new Stack < > ();
        Stack < String > pre = new Stack < > ();
        Stack < Character > ops = new Stack < > ();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                ops.push(ch);
            } else if (Character.isDigit(ch) || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    char op = ops.pop();
                    String v2 = post.pop();
                    String v1 = post.pop();
                    String postV = v1 + v2 + op;
                    post.push(postV);
                    
                    String s2 = pre.pop();
                    String s1 = pre.pop();
                    String preV = op + s1 + s2;
                    pre.push(preV);
                }
                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ops.size() > 0 && ops.peek() != '(' && prio(ch) <= prio(ops.peek())) {
                    char op = ops.pop();
                    String v2 = post.pop();
                    String v1 = post.pop();
                    String postV = v1 + v2 + op;
                    post.push(postV);
                    
                    String s2 = pre.pop();
                    String s1 = pre.pop();
                    String preV = op + s1 + s2;
                    pre.push(preV);
                }
                ops.push(ch);
            }
        }
        while(ops.size()>0){
            char op = ops.pop();
            String v2 = post.pop();
            String v1 = post.pop();
            String postV = v1 + v2 + op;
            post.push(postV);
            
            String s2 = pre.pop();
            String s1 = pre.pop();
            String preV = op + s1 + s2;
            pre.push(preV);
        }
        System.out.println(post.pop());
        System.out.println(pre.pop());
    }
    public static int prio(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
