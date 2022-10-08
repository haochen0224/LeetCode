package DP;

/**
 * 740. 删除并获得点数
 * @Author Hao Chen
 * @Create 2022/10/7 18:33
 */
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int maxVal = 0;
        for(int num : nums){
            maxVal = Math.max(maxVal,num);
        }
        int[] sum = new int[maxVal+1];
        for(int num : nums){
            sum[num] += num;
        }
        return rob(sum);
    }
    private int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for(int i = 2; i <= n; ++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}
