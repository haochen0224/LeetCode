package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. 反转每对括号间的子串
 * @Author Hao Chen
 * @Create 2022/7/16 19:09
 */
public class Solution1190 {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int[] pair = new int[s.length()];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else if(ch == ')'){
                int j = stack.pop();
                pair[j] = i;
                pair[i] = j;
            }
        }
        StringBuffer res = new StringBuffer();
        int index = 0;
        int direction = 1;
        while(index < s.length()){
            char ch = s.charAt(index);
            if(ch == '(' || ch == ')'){
                index = pair[index];
                direction = -direction;
            }else{
                res.append(ch);
            }
            index += direction;
        }
        return res.toString();
    }
    // public String reverseParentheses(String s) {
    //     Deque<String> stack = new LinkedList<>();
    //     StringBuffer res = new StringBuffer();
    //     for(int i = 0; i < s.length(); ++i){
    //         char ch = s.charAt(i);
    //         if(ch == '('){
    //             stack.push(res.toString());
    //             res.setLength(0);
    //         }else if(ch == ')'){
    //             res.reverse();
    //             res.insert(0,stack.pop());
    //         }else{
    //             res.append(ch);
    //         }
    //     }
    //     return res.toString();
    // }
}
