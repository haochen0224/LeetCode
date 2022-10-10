package DP;

/**
 * 918. 环形子数组的最大和
 * @Author Hao Chen
 * @Create 2022/10/9 13:59
 */
public class Solution918 {
    /**
     * 两种情况：
     * （1）最大子数组不构成环，按普通情况的最大子数组和处理；
     * （2）最大子数组构成环，那么最大子数组为数组和减去最小子数组
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n+1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; ++i){
            dp[i] = Math.max(nums[i-1],dp[i-1]+nums[i-1]);
            max = Math.max(max,dp[i]);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; ++i){
            dp[i] = Math.min(nums[i-1],dp[i-1]+nums[i-1]);
            min = Math.min(min,dp[i]);
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return max > 0 ? Math.max(max,sum-min) : max;
    }
}
