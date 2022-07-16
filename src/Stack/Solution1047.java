package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * @Author Hao Chen
 * @Create 2022/7/16 13:40
 */
public class Solution1047 {
    public String removeDuplicates(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuffer res = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && res.charAt(top) == ch) {
                res.deleteCharAt(top);
                --top;
            } else {
                res.append(ch);
                ++top;
            }
        }
        return res.toString();
    }
//    public String removeDuplicates(String s) {
//        if(s.length() == 0){
//            return "";
//        }
//        Deque<Character> stack = new LinkedList<>();
//        for(int i = 0; i < s.length(); ++i){
//            char ch = s.charAt(i);
//            if(!stack.isEmpty() && stack.peek() == ch){
//                while(!stack.isEmpty() && stack.peek() == ch){
//                    stack.pop();
//                }
//            }else{
//                stack.push(ch);
//            }
//        }
//        StringBuffer res = new StringBuffer();
//        while(!stack.isEmpty()){
//            res.append(stack.pop());
//        }
//        res.reverse();
//        return res.toString();
//    }
}
