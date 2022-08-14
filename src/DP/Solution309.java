package DP;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * @Author Hao Chen
 * @Create 2022/8/14 17:24
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1){
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1],dp[0][0]-prices[1]);
        for(int i = 2; i < n; ++i){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
