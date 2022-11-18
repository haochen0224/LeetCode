package DP;

/**
 * 650. 只有两个键的键盘
 * @Author Hao Chen
 * @Create 2022/11/17 18:56
 */
public class Solution650 {
    public int minSteps(int n) {
        if(n <= 0){
            return 0;
        }
        int[] dp = new int[n+1];
        for(int i = 2; i <= n; ++i){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; ++j){
                if(i%j == 0){
                    dp[i] = Math.min(dp[i],dp[j]+i/j);
                    dp[i] = Math.min(dp[i],dp[i/j]+j);
                }
            }
        }
        return dp[n];
    }
}
