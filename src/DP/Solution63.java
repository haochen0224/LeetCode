package DP;

/**
 * 63. 不同路径 II
 * @Author Hao Chen
 * @Create 2022/9/17 19:02
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int j = 0; j < n && obstacleGrid[0][j] != 1; ++j){
            dp[0][j] = 1;
        }
        for(int i = 0; i < m && obstacleGrid[i][0] != 1; ++i){
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
