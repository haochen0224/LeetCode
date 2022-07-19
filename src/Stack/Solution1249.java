package Stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 1249. 移除无效的括号
 * @Author Hao Chen
 * @Create 2022/7/18 17:39
 */
public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else if(ch == ')'){
                if(stack.isEmpty()){
                    indexToRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            indexToRemove.add(stack.pop());
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < s.length(); ++i){
            if(!indexToRemove.contains(i)){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
