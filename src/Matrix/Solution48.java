package Matrix;

/**
 * 48. 旋转图像
 * @Author Hao Chen
 * @Create 2022/7/28 19:23
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先垂直翻转
        for(int i = 0; i < n/2; ++i){
            for(int j = 0; j < n; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        //在沿对角线翻转
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
