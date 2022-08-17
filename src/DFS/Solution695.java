package DFS;

/**
 * 695. 岛屿的最大面积
 * @Author Hao Chen
 * @Create 2022/8/17 18:22
 */
public class Solution695 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }
    private int dfs(int[][] grid,int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1){
            return 0;
        }
        grid[x][y] = 0;
        int res = 1;
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            res += dfs(grid,nx,ny);
        }
        return res;
    }
}
