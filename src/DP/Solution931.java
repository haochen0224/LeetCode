package DP;

/**
 * 931. 下降路径最小和
 * @Author Hao Chen
 * @Create 2022/8/12 19:06
 */
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; ++i){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(j == n-1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }else if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1])) + matrix[i][j];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            res = Math.min(res,dp[m-1][i]);
        }
        return res;
    }
}
