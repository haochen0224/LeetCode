package COMPANY.ByteDance.DP;

/**
 * 300. 最长递增子序列
 * @Author Hao Chen
 * @Create 2022/8/2 19:23
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n]; //dp表示以下标i结尾的最大递增子序列长度
        dp[0] = 1;
        int res = 1; //结果不一定是以数组最后一位结尾的，因此用res保存可能出现在中间过程中的结果
        for(int i = 1; i < n; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
