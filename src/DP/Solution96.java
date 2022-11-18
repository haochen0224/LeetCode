package DP;

/**
 * 96. 不同的二叉搜索树
 * @Author Hao Chen
 * @Create 2022/11/17 19:02
 */
public class Solution96 {
    public int numTrees(int n) {
        if(n <= 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
