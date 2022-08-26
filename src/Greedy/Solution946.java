package Greedy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 946. 验证栈序列
 * @Author Hao Chen
 * @Create 2022/8/26 17:06
 */
public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || popped == null){
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        int n = popped.length;
        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && j < n && popped[j] == stack.peek()){
                stack.pop();
                ++j;
            }
        }
        return j == n && stack.isEmpty() ? true : false;
    }
}
