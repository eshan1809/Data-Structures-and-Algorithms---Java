/*
1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.
Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
*/


import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack <Integer> vs = new Stack<>();
        Stack <String> in = new Stack<>();
        Stack <String> pre = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)){
                vs.push(ch-'0');
                in.push(ch+"");
                pre.push(ch+"");
            }
            else{
                int v2 = vs.pop();
                int v1 = vs.pop();
                int v = operation(v1,v2,ch);
                vs.push(v);
                
                String i2 = in.pop();
                String i1 = in.pop();
                in.push('(' + i1 + ch + i2 + ')');
                
                String p2 = pre.pop();
                String p1 = pre.pop();
                pre.push(ch + p1 + p2);
            }
        }
        System.out.println(vs.pop());
        System.out.println(in.pop());
        System.out.println(pre.pop());
    }
    public static int prio(char ch) {
        if(ch=='+' || ch=='-'){
            return 1;
        }
        return 2;
    }
    public static int operation(int v1, int v2, char ch){
        if(ch=='+'){
            return v1+v2;
        }
        else if(ch=='-'){
            return v1-v2;
        }
        else if(ch=='*'){
            return v1*v2;
        }
        return v1/v2;
    }
}
