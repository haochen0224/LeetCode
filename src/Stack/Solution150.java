package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 * @Author Hao Chen
 * @Create 2022/7/17 18:34
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < tokens.length; ++i){
            String str = tokens[i];
            if(isNumber(str)){
                stack.push(str);
            }else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if(str.equals("+")){
                    stack.push(String.valueOf(num1+num2));
                }else if(str.equals("-")){
                    stack.push(String.valueOf(num2-num1));
                }else if(str.equals("*")){
                    stack.push(String.valueOf(num1*num2));
                }else{
                    stack.push(String.valueOf(num2/num1));
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
    private boolean isNumber(String s){
        return !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
}
