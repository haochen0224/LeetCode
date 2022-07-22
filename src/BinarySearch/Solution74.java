package BinarySearch;

/**
 * 74. 搜索二维矩阵
 * @Author Hao Chen
 * @Create 2022/7/21 21:07
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] array = new int[m*n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                array[i*n+j] = matrix[i][j];
            }
        }
        int left = 0, right = array.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(array[mid] == target){
                return true;
            }
            if(array[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
