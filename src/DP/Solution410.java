package DP;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 * @Author Hao Chen
 * @Create 2022/9/23 17:17
 */
public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; ++i){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        int[] sub = new int[n+1];
        for(int i = 0; i < n; ++i){
            sub[i+1] = sub[i] + nums[i];
        }
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= Math.min(i,m); ++j){
                for(int k = 0; k < i; ++k){
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[k][j-1],sub[i]-sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}
