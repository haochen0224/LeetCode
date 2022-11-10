package DP;

/**
 * 673. 最长递增子序列的个数
 * @Author Hao Chen
 * @Create 2022/11/8 13:34
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n+1];
        int[] cnt = new int[n+1];
        int maxLen = 1;
        for(int i = 1; i <= n; ++i){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j = 1; j < i; ++j){
                if(nums[i-1] > nums[j-1]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if(dp[i] == dp[j]+1){
                        cnt[i] += cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        int res = 0;
        for(int i = 1; i <= n; ++i){
            if(dp[i] == maxLen){
                res += cnt[i];
            }
        }
        return res;
    }
}
