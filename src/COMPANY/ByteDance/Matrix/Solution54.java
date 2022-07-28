package COMPANY.ByteDance.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * @Author Hao Chen
 * @Create 2022/7/27 19:24
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;
        int numLen = matrix[0].length * matrix.length;
        List<Integer> res = new ArrayList<>();
        while(numLen >= 1){
            for(int i = left; i <= right && numLen >= 1; ++i){
                res.add(matrix[top][i]);
                --numLen;
            }
            ++top;
            for(int i = top; i <= bottom && numLen >= 1; ++i){
                res.add(matrix[i][right]);
                --numLen;
            }
            --right;
            for(int i = right; i >= left && numLen >= 1; --i){
                res.add(matrix[bottom][i]);
                --numLen;
            }
            --bottom;
            for(int i = bottom; i >= top && numLen >= 1; --i){
                res.add(matrix[i][left]);
                --numLen;
            }
            ++left;
        }
        return res;
    }
}
