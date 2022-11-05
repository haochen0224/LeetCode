package DP;

/**
 * 1746. 经过一次操作后的最大子数组和
 * @Author Hao Chen
 * @Create 2022/11/5 19:24
 */
public class Solution1746 {
    public int maxSumAfterOperation(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        int res = nums[0];
        for(int i = 1; i <= n; ++i){
            dp[i][0] = Math.max(dp[i-1][0],0) + nums[i-1];
            dp[i][1] = Math.max(Math.max(dp[i-1][0],0)+nums[i-1]*nums[i-1],dp[i-1][1]+nums[i-1]);
            res = Math.max(res,Math.max(dp[i][0],dp[i][1]));
        }
        return res;
    }
}
