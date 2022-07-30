package DP;

/**
 * 746. 使用最小花费爬楼梯
 * @Author Hao Chen
 * @Create 2022/7/29 20:41
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        //阶梯下标为0,1,...,n-1，楼顶下标为n
        //dp[i]表示到达i位置的花费
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; ++i){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}
