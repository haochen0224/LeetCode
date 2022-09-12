package DFS;

/**
 * 329. 矩阵中的最长递增路径
 * @Author Hao Chen
 * @Create 2022/9/9 17:03
 */
public class Solution329 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int m;
    int n;
    int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                res = Math.max(res,dfs(i,j,memo));
            }
        }
        return res;
    }
    private int dfs(int x,int y,int[][] memo){
        if(memo[x][y] != 0){
            return memo[x][y];
        }
        ++memo[x][y];
        for(int i = 0; i < 4; ++i){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && matrix[nextX][nextY] > matrix[x][y]){
                memo[x][y] = Math.max(memo[x][y],dfs(nextX,nextY,memo)+1);
            }
        }
        return memo[x][y];
    }
}
