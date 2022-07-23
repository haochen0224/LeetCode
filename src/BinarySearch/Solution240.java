package BinarySearch;

/**
 * 240. 搜索二维矩阵 II
 * @Author Hao Chen
 * @Create 2022/7/22 21:05
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] cur : matrix){
            int left = 0, right = matrix[0].length-1;
            while(left <= right){
                int mid = left + (right-left)/2;
                if(cur[mid] == target){
                    return true;
                }
                if(cur[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
    //更快的实现：Z字型查找
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int x = 0, y = n-1;
//        while(x < m && y >= 0){
//            if(matrix[x][y] == target){
//                return true;
//            }
//            if(matrix[x][y] > target){
//                --y;
//            }else {
//                ++x;
//            }
//        }
//        return false;
//    }
}
