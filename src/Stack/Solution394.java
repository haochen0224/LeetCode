package Stack;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 394. 字符串解码
 * @Author Hao Chen
 * @Create 2022/7/16 20:18
 */
public class Solution394 {
    int ptr = 0;
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        while(ptr < s.length()){
            char ch = s.charAt(ptr);
            if(Character.isDigit(ch)){
                String num = getDigit(s);
                stack.push(num);
            }else if(ch == '[' || Character.isLetter(ch)){
                stack.push(String.valueOf(ch));
                ++ptr;
            }else{
                ++ptr;
                List<String> list = new LinkedList<>();
                while(!stack.peek().equals("[")){
                    list.add(stack.pop());
                }
                stack.pop();
                Collections.reverse(list);
                String sub = getLetters(list);
                int repeat = Integer.valueOf(stack.pop());
                StringBuffer temp = new StringBuffer();
                while(repeat-- > 0){
                    temp.append(sub);
                }
                stack.push(temp.toString());
            }
        }
        StringBuffer res = new StringBuffer();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        return res.toString();
    }

    private String getLetters(List<String> list){
        StringBuffer res = new StringBuffer();
        for(String s : list){
            res.append(s);
        }
        return res.toString();
    }

    private String getDigit(String s){
        StringBuffer res = new StringBuffer();
        while(Character.isDigit(s.charAt(ptr))){
            res.append(s.charAt(ptr));
            ++ptr;
        }
        return res.toString();
    }
}
