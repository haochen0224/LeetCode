package DP;

/**
 * 375. 猜数字大小 II
 * @Author Hao Chen
 * @Create 2022/8/29 20:20
 */
public class Solution375 {
    public int getMoneyAmount(int n) {
        if(n <= 0){
            return 0;
        }
        int[][] dp = new int[n+2][n+2];
        for(int L = 2; L <= n; ++L){
            for(int i = 1; i+L-1 <= n; ++i){
                int j = i+L-1;
                int minCost = Integer.MAX_VALUE;
                for(int k = i; k <= j; ++k){
                    int cost = k + Math.max(dp[i][k-1],dp[k+1][j]);
                    minCost = Math.min(minCost,cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];
    }
}
