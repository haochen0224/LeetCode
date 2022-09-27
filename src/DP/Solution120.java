package DP;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * @Author Hao Chen
 * @Create 2022/9/26 19:08
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return Integer.MIN_VALUE;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; ++i){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j = 1; j < i; ++j){
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int res = dp[n-1][0];
        for(int i = 1; i < n; ++i){
            res = Math.min(res,dp[n-1][i]);
        }
        return res;
    }
}
