package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * @Author Hao Chen
 * @Create 2022/7/17 18:19
 */
public class Solution227 {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); ++i){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1){
                switch(preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    default:
                        stack.push(stack.pop()/num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
