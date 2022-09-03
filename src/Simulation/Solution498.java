package Simulation;

/**
 * 498. 对角线遍历
 * @Author Hao Chen
 * @Create 2022/9/2 19:18
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null){
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int pos = 0;
        for(int i = 0; i < m+n-1; ++i){
            if(i%2 == 0){
                int x = i < m ? i : m-1;
                int y = i < m ? 0 : i-m+1;
                while(x >= 0 && y < n){
                    res[pos++] = mat[x--][y++];
                }
            }else{
                int x = i < n ? 0 : i-n+1;
                int y = i < n ? i : n-1;
                while(x < m && y >= 0){
                    res[pos++] = mat[x++][y--];
                }
            }
        }
        return res;
    }
}
