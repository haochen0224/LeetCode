package DP;

/**
 * 1314. 矩阵区域和
 * @Author Hao Chen
 * @Create 2022/10/23 18:53
 */
public class Solution1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        if(mat == null){
            return null;
        }
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m+1][n+1];
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int[][] res = new int[m][n];
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                int x1 = i - k < 1 ? 1 : i - k;
                int y1 = j - k < 1 ? 1 : j - k;
                int x2 = i + k > m ? m : i + k;
                int y2 = j + k > n ? n : j + k;
                res[i-1][j-1] = prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
            }
        }
        return res;
    }
}
