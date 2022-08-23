package DFS;

/**
 * 200. 岛屿数量
 * @Author Hao Chen
 * @Create 2022/8/22 19:06
 */
public class Solution200 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    boolean[][] visited;
    int m;
    int n;
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i,j);
                    ++res;
                }
            }
        }
        return res;
    }
    private void dfs(int x,int y){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1'){
                dfs(nx,ny);
            }
        }
    }
}
