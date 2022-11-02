package DP;

/**
 * 256. 粉刷房子
 * @Author Hao Chen
 * @Create 2022/11/2 19:16
 */
public class Solution256 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n+1][3];
        for(int i = 1; i <= n; ++i){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i-1][2];
        }
        return Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
    }
}
