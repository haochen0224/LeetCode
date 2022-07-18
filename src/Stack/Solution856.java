package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 856. 括号的分数
 * @Author Hao Chen
 * @Create 2022/7/17 19:42
 */
public class Solution856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(0);
            }else if(ch == ')'){
                if(stack.peek() == 0){
                    stack.pop();
                    stack.push(1);
                }else{
                    int sum = 0;
                    while(stack.peek() != 0){
                        sum += stack.pop();
                    }
                    stack.pop();
                    stack.push(sum * 2);
                }
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
