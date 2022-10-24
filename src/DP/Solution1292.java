package DP;

/**
 * 1292. 元素和小于等于阈值的正方形的最大边长
 * @Author Hao Chen
 * @Create 2022/10/23 18:23
 */
public class Solution1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        if(mat == null){
            return 0;
        }
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m+1][n+1];
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int left = 0, right = Math.min(m,n);
        int res = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            boolean flag = false;
            for(int i = 1; i + mid - 1 <= m; ++i){
                for(int j = 1; j + mid - 1 <= n; ++j){
                    int cur = prefix[i+mid-1][j+mid-1] - prefix[i-1][j+mid-1] - prefix[i+mid-1][j-1] + prefix[i-1][j-1];
                    if(cur <= threshold){
                        flag = true;
                    }
                }
            }
            if(flag){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }
}
