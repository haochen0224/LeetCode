package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. 和至少为 K 的最短子数组
 * @Author Hao Chen
 * @Create 2022/9/13 16:56
 */
public class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        if(nums.length == 0){
            return -1;
        }
        int n = nums.length;
        long[] preSum = new long[n+1];
        for(int i = 1; i <= n; ++i){
            preSum[i] = preSum[i-1] + (long)nums[i-1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int minLen = n+1;
        for(int i = 0; i < preSum.length; ++i){
            while(!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]){
                deque.pollLast();
            }
            while(!deque.isEmpty() && preSum[i]-preSum[deque.peekFirst()] >= k){
                minLen = Math.min(minLen,i-deque.pollFirst());
            }
            deque.offerLast(i);
        }
        return minLen == n+1 ? -1 : minLen;
    }
}
