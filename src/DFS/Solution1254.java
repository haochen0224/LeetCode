package DFS;

/**
 * 1254. 统计封闭岛屿的数目
 * @Author Hao Chen
 * @Create 2022/9/1 16:42
 */
public class Solution1254 {
    int m;
    int n;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    boolean[][] visited;
    public int closedIsland(int[][] grid) {
        if(grid == null){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            if(grid[i][0] == 0){
                dfs(grid,i,0);
            }
            if(grid[i][n-1] == 0){
                dfs(grid,i,n-1);
            }
        }
        for(int i = 0; i < n; ++i){
            if(grid[0][i] == 0){
                dfs(grid,0,i);
            }
            if(grid[m-1][i] == 0){
                dfs(grid,m-1,i);
            }
        }
        int count = 0;
        for(int i = 1; i < m-1; ++i){
            for(int j = 1; j < n-1; ++j){
                if(grid[i][j] == 0 && !visited[i][j]){
                    dfs(grid,i,j);
                    ++count;
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid,int x,int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 0){
                dfs(grid,nx,ny);
            }
        }
    }
}
