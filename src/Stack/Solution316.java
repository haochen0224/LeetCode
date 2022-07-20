package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 316. 去除重复字母
 * @Author Hao Chen
 * @Create 2022/7/19 18:17
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(deque.contains(ch)){
                continue;
            }
            //s.indexOf(deque.peekLast(),i) != -1 栈顶的字符在i位置之后还出现过，因此可以将它移除
            while(!deque.isEmpty() && ch < deque.peekLast() && s.indexOf(deque.peekLast(),i) != -1){
                deque.pollLast();
            }
            deque.offerLast(ch);
        }
        StringBuffer res = new StringBuffer();
        while(!deque.isEmpty()){
            res.append(deque.pollFirst());
        }
        return res.toString();
    }
}
