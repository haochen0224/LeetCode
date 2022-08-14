package DP;

/**
 * 188. 买卖股票的最佳时机 IV
 * @Author Hao Chen
 * @Create 2022/8/14 18:01
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0 || prices == null){
            return 0;
        }
        if(k > n/2){
            return maxProfitInf(prices);
        }
        int[][][] dp = new int[n][k+1][2];
        //对 k=0 的情况初始化
        for(int i = 0; i < n; ++i){
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        //对 i=0 的情况初始化
        for(int j = 1; j <= k; ++j){
            dp[0][j][1] = -prices[0];
        }
        for(int i = 1; i < n; ++i){
            for(int j = 1; j <= k; ++j){
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];
    }
    private int maxProfitInf(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; ++i){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
