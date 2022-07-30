package COMPANY.ByteDance.DP;

/**
 * 122. 买卖股票的最佳时机 II
 * @Author Hao Chen
 * @Create 2022/7/25 18:23
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; ++i){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            ////不同于121题只能买进卖出一只股票，该题可以多次买进卖出
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
