package COMPANY.ByteDance.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * @Author Hao Chen
 * @Create 2022/8/9 19:41
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; ++i){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            if(i+1 >= k){
                res[i+1-k] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
