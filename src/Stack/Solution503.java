package Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 * @Author Hao Chen
 * @Create 2022/7/17 18:51
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i = 0; i < 2*n-1; ++i){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){
                res[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }
        return res;
    }
}
