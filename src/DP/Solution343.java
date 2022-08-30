package DP;

/**
 * 343. 整数拆分
 * @Author Hao Chen
 * @Create 2022/8/29 18:35
 */
public class Solution343 {
    public int integerBreak(int n) {
        if(n <= 0){
            return 0;
        }
        int[] dp = new int[n+1];
        for(int i = 2; i <= n; ++i){
            int curMax = 0;
            for(int j = 1; j < i; ++j){
                curMax = Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
