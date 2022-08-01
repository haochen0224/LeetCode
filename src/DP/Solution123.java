package DP;

/**
 * 123. 买卖股票的最佳时机 III
 * @Author Hao Chen
 * @Create 2022/7/30 15:36
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[][][] dp = new int[n][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for(int i = 1; i < n; ++i){
            dp[i][1][1] = Math.max(dp[i-1][1][1],-prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
            dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][1][0]-prices[i]);
            dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i-1][2][1]+prices[i]);
        }
        return Math.max(dp[n-1][1][0],dp[n-1][2][0]);
    }
}
