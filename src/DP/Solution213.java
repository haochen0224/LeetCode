package DP;

/**
 * 213. 打家劫舍 II
 * @Author Hao Chen
 * @Create 2022/8/14 16:35
 */
public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; ++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        int a = dp[n];
        dp[1] = nums[0];
        for(int i = 2; i <= n-1; ++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        int b = dp[n-1];
        return Math.max(a,b);
    }
}
