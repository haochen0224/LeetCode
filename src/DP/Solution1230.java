package DP;

/**
 * 1230. 抛掷硬币
 * @Author Hao Chen
 * @Create 2022/11/5 19:33
 */
public class Solution1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        if(prob == null || prob.length == 0){
            return 0.0;
        }
        int n = prob.length;
        double[][] dp = new double[n+1][n+1]; //dp[i][j] 表示前 i 个硬币中正面朝上硬币数为 j 的概率
        dp[0][0] = 1;
        for(int i = 1; i <= n; ++i){
            dp[i][0] = dp[i-1][0] * (1-prob[i-1]); //初始化
        }
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i && j <= target; ++j){
                // 两种情况：（1）前 i-1 个硬币已经有 j 个硬币正面朝上了
                //         （2）前 i-1 个硬币有 j-1 个正面硬币朝上
                dp[i][j] = dp[i-1][j]*(1-prob[i-1]) + dp[i-1][j-1]*prob[i-1];
            }
        }
        return dp[n][target];
    }
}
