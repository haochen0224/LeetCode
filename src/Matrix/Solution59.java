package Matrix;

/**
 * 59. 螺旋矩阵 II
 * @Author Hao Chen
 * @Create 2022/7/28 18:42
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int target = n * n;
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        int[][] res = new int[n][n];
        int num = 1;
        while(num <= target){
            for(int i = left; i <= right && num <= target; ++i){
                res[top][i] = num++;
            }
            ++top;
            for(int i = top; i <= bottom && num <= target; ++i){
                res[i][right] = num++;
            }
            --right;
            for(int i = right; i >= left && num <= target; --i){
                res[bottom][i] = num++;
            }
            --bottom;
            for(int i = bottom; i >= top && num <= target; --i){
                res[i][left] = num++;
            }
            ++left;
        }
        return res;
    }
}
