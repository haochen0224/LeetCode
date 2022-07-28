package Matrix;

/**
 * 867. 转置矩阵
 * @Author Hao Chen
 * @Create 2022/7/28 18:16
 */
public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
