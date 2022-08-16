package DP;

/**
 * 221. 最大正方形
 * @Author Hao Chen
 * @Create 2022/8/16 18:15
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        //以i,j为右下角的正方形的最大边长取决于左、左上、上的正方形的最大边长的最小值
                        //因为若取左、左上、上的最大值+1的话，那么新正方形可能缺角（新正方形覆盖的区域中存在0）
                        //如果取三者最小值+1，则一定不会缺角
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen*maxLen;
    }
}
