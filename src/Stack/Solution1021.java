package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1021. 删除最外层的括号
 * @Author Hao Chen
 * @Create 2022/7/16 17:51
 */
public class Solution1021 {
    public String removeOuterParentheses(String s) {
        StringBuffer res = new StringBuffer();
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == ')'){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res.append(ch);
            }
            if(ch == '('){
                stack.push(ch);
            }
        }
        return res.toString();
    }
}
