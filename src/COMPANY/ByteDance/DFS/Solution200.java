package COMPANY.ByteDance.DFS;

/**
 * 200. 岛屿数量
 * @Author Hao Chen
 * @Create 2022/7/27 20:10
 */
public class Solution200 {
    int m;
    int n;
    char[][] grid;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        int count = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1'){
                    ++count;
                    dfs(i,j);
                }
            }
        }
        return count;
    }
    private void dfs(int x, int y){
        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1'){
            grid[x][y] = '0';
            for(int i = 0; i < 4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx,ny);
            }
        }
    }
}
