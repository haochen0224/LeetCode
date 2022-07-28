package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * @Author Hao Chen
 * @Create 2022/7/28 18:37
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n-1;
        int top = 0, bottom = m-1;
        int numLen = m * n;
        while(numLen > 0){
            for(int i = left; i <= right && numLen > 0; ++i){
                res.add(matrix[top][i]);
                --numLen;
            }
            ++top;
            for(int i = top; i <= bottom && numLen > 0; ++i){
                res.add(matrix[i][right]);
                --numLen;
            }
            --right;
            for(int i = right; i >= left && numLen > 0; --i){
                res.add(matrix[bottom][i]);
                --numLen;
            }
            --bottom;
            for(int i = bottom; i >= top && numLen > 0; --i){
                res.add(matrix[i][left]);
                --numLen;
            }
            ++left;
        }
        return res;
    }
}
