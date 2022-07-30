package COMPANY.ByteDance.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. 每日温度
 * @Author Hao Chen
 * @Create 2022/7/29 19:05
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; ++i){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
