package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 * @Author Hao Chen
 * @Create 2022/7/19 17:58
 */
public class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < num.length(); ++i){
            char digit = num.charAt(i);
            while(!deque.isEmpty() && k > 0 && digit < deque.peekLast()){
                deque.pollLast();
                --k;
            }
            deque.offerLast(digit);
        }

        for(int i = 0; i < k; ++i){
            deque.pollLast();
        }

        StringBuffer res = new StringBuffer();
        boolean leadingZero = true;
        while(!deque.isEmpty()){
            char digit = deque.pollFirst();
            if(leadingZero && digit == '0'){
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
