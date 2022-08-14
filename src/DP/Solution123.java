package DP;

/**
 * 123. 买卖股票的最佳时机 III
 * @Author Hao Chen
 * @Create 2022/7/30 15:36
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxK = 2;
        int[][][] dp = new int[n][maxK+1][2];
        for(int k = 1; k <= maxK; ++k){
            dp[0][k][1] = -prices[0];
        }
        for(int i = 1; i < n; ++i){
            for(int k = 1; k <= maxK; ++k){
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][maxK][0];
    }
}
