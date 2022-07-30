package COMPANY.ByteDance.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * @Author Hao Chen
 * @Create 2022/7/29 19:53
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }
}
