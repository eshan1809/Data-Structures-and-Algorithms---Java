/*
1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.
Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
*/


import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> vs = new Stack<>();
    Stack<String> in = new Stack<>();
    Stack<String> post = new Stack<>();
    for(int i=exp.length()-1;i>=0;i--){
        char ch = exp.charAt(i);
        if(Character.isDigit(ch)){
            vs.push(ch-'0');
            in.push(ch+"");
            post.push(ch+"");
        }
        else{
            int v1 = vs.pop();
            int v2 = vs.pop();
            int v = operation(v1,v2,ch);
            vs.push(v);
            
            String i1 = in.pop();
            String i2 = in.pop();
            in.push('(' + i1 + ch + i2 + ')');
            
            String p1 = post.pop();
            String p2 = post.pop();
            post.push(p1 + p2 + ch);
        }
    }
    System.out.println(vs.pop());
    System.out.println(in.pop());
    System.out.println(post.pop());
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
