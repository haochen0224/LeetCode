package COMPANY.ByteDance.DP;

/**
 * 70. 爬楼梯
 * @Author Hao Chen
 * @Create 2022/7/27 18:20
 */
public class Solution70 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
