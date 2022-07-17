package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 456. 132 模式
 * @Author Hao Chen
 * @Create 2022/7/16 23:37
 */
public class Solution456 {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int k = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = n-1; i >= 0; --i){
            if(nums[i] < k){
                return true;
            }
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                k = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
