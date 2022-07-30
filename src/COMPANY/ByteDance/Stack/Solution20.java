package COMPANY.ByteDance.Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * @Author Hao Chen
 * @Create 2022/7/25 17:35
 */
public class Solution20 {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
