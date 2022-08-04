package COMPANY.ByteDance.DP;

/**
 * 221. 最大正方形
 * @Author Hao Chen
 * @Create 2022/8/4 18:46
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix == null || m == 0 || n == 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
