package COMPANY.ByteDance.DP;

/**
 * 198. 打家劫舍
 * @Author Hao Chen
 * @Create 2022/8/1 18:30
 */
public class Solution198 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n+1]; //dp表示从前i个房间偷取的最大金额
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= n; ++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}
