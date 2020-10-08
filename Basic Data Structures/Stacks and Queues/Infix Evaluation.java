/*
1. You are given an infix expression.
2. You are required to evaluate and print it's value.
*/


import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Character> ops = new Stack<>();   //operators->ops
    Stack<Integer> ors = new Stack<>();   //operands->ors
    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        if(ch=='('){
            ops.push(ch);
        }
        else if(Character.isDigit(ch)){
            ors.push(ch-'0');
        }
        else if(ch==')'){
            while(ops.peek()!='('){
                char op = ops.pop();
                int v2 = ors.pop();
                int v1 = ors.pop();
                int or = operation(v1,v2,op);
                ors.push(or);
            }
            ops.pop();
        }
        else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            while(ops.size()>0 && ops.peek()!='(' && pre(ch)<=pre(ops.peek())){
                char op = ops.pop();
                int v2 = ors.pop();
                int v1 = ors.pop();
                int or = operation(v1,v2,op);
                ors.push(or);
            }
            ops.push(ch);
        }
    }
    while(ops.size()!=0){
        char op = ops.pop();
        int v2 = ors.pop();
        int v1 = ors.pop();
        int or = operation(v1,v2,op);
        ors.push(or);
    }
    System.out.print(ors.peek());
 }

public static int pre(char op){
    if(op=='+' || op=='-'){
        return 1;
    }
    return 2;
}
public static int operation(int v1, int v2, char op){
    if(op=='+'){
        return v1+v2;
    }
    else if(op=='-'){
        return v1-v2;
    }
    else if(op=='*'){
        return v1*v2;
    }
    else{
        return v1/v2;
    }
}
}
