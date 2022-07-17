package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 844. 比较含退格的字符串
 * @Author Hao Chen
 * @Create 2022/7/16 18:15
 */
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    private String build(String str){
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(res.length() > 0 && ch == '#'){
                res.deleteCharAt(res.length()-1);
            }
            if(ch != '#'){
                res.append(ch);
            }
        }
        return res.toString();
    }
//    public boolean backspaceCompare(String s, String t) {
//        Deque<Character> stack1 = new LinkedList<>();
//        Deque<Character> stack2 = new LinkedList<>();
//        for(int i = 0; i < s.length(); ++i){
//            char ch = s.charAt(i);
//            if(!stack1.isEmpty() && ch == '#'){
//                stack1.pop();
//            }
//            if(ch != '#'){
//                stack1.push(ch);
//            }
//        }
//        for(int i = 0; i < t.length(); ++i){
//            char ch = t.charAt(i);
//            if(!stack2.isEmpty() && ch == '#'){
//                stack2.pop();
//            }
//            if(ch != '#'){
//                stack2.push(ch);
//            }
//        }
//        while(!stack1.isEmpty() && !stack2.isEmpty()){
//            if(stack1.pop() != stack2.pop()){
//                return false;
//            }
//        }
//        return stack1.isEmpty() && stack2.isEmpty();
//    }
}
