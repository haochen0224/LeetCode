package BinarySearch;

/**
 * 1351. 统计有序矩阵中的负数
 * @Author Hao Chen
 * @Create 2022/11/7 17:47
 */
public class Solution1351 {
    public int countNegatives(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; ++i){
            int first = binarySearch(grid[i]);
            res += n - first;
        }
        return res;
    }
    private int binarySearch(int[] row){
        int left = 0, right = row.length-1;
        int res = row.length;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(row[mid] < 0){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}
