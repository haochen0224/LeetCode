package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 682. 棒球比赛
 * @Author Hao Chen
 * @Create 2022/7/16 18:05
 */
public class Solution682 {
    public int calPoints(String[] ops) {
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < ops.length; ++i){
            String str = ops[i];
            if(str.equals("C")){
                stack.pop();
            }else if(str.equals("D")){
                int pre = Integer.parseInt(stack.peek());
                int score = 2 * pre;
                stack.push(String.valueOf(score));
            }else if(str.equals("+")){
                int pre1 = Integer.parseInt(stack.pop());
                int pre2 = Integer.parseInt(stack.peek());
                stack.push(String.valueOf(pre1));
                int score = pre1 + pre2;
                stack.push(String.valueOf(score));
            }else{
                stack.push(str);
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += Integer.parseInt(stack.pop());
        }
        return res;
    }
}
