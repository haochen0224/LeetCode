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
            //(1)贪心思想。目标是要找 pre[j]-pre[i]>=k，因此pre[i]大，越不容易找到答案，因此要使得pre[i]尽可能小
            //(2)k>=1，因此preSum[i]-preSum[deque.peekFirst()]>=1，因此要把preSum[deque.peekLast()]>=preSum[i]的前缀和移出队列
            while(!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]){
                deque.pollLast();
            }
            //不断缩减子数组长度，找到最小的满足条件的答案
            while(!deque.isEmpty() && preSum[i]-preSum[deque.peekFirst()] >= k){
                minLen = Math.min(minLen,i-deque.pollFirst());
            }
            deque.offerLast(i);
        }
        return minLen == n+1 ? -1 : minLen;
    }
}
