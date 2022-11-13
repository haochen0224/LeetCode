package DP;

/**
 * 562. 矩阵中最长的连续1线段
 * @Author Hao Chen
 * @Create 2022/11/12 23:02
 */
public class Solution562 {
    public int longestLine(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0){
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        int[][][] dp = new int[m+2][n+2][4]; //第三个维度表示水平、垂直、对角线、反对角线四个方向上的最长连续 1 的长度
                                            //这里数组开辟大小为[m+2][n+2]是因为考虑到状态转移可能存在越界，因此多开辟一行和一列
        int res = 0;
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(mat[i-1][j-1] == 1){
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                    dp[i][j][2] = dp[i-1][j-1][2] + 1;
                    dp[i][j][3] = dp[i-1][j+1][3] + 1;
                }
                int curMax = getMax(dp[i][j]);
                if(res < curMax){
                    res = curMax;
                }
            }
        }
        return res;
    }
    private int getMax(int[] nums){
        int curMax = 0;
        for(int num : nums){
            if(num > curMax){
                curMax = num;
            }
        }
        return curMax;
    }
}
