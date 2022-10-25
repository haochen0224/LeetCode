package DP;

/**
 * 面试题 17.24. 最大子矩阵
 * @Author Hao Chen
 * @Create 2022/10/24 18:11
 */
public class Interview17_24 {
    public int[] getMaxMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m+1][n+1];
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        int globalMax = Integer.MIN_VALUE;
        int[] res = new int[4];
        for(int top = 0; top < m; ++top){
            for(int bottom = top; bottom < m; ++bottom){
                int localMax = 0;
                int left = 0;
                for(int right = 0; right < n; ++right){
                    localMax = prefix[bottom+1][right+1] - prefix[top][right+1] - prefix[bottom+1][left] + prefix[top][left];
                    if(localMax > globalMax){
                        globalMax = localMax;
                        res[0] = top;
                        res[1] = left;
                        res[2] = bottom;
                        res[3] = right;
                    }
                    if(localMax < 0){
                        left = right + 1;
                    }
                }
            }
        }
        return res;
    }
}
