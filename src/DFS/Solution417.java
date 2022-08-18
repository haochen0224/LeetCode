package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * @Author Hao Chen
 * @Create 2022/8/18 18:23
 */
public class Solution417 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int[][] heights;
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] Pacific = new boolean[m][n];
        boolean[][] Atlantic = new boolean[m][n];
        for(int j = 0; j < n; ++j){
            dfs(0,j,Pacific);
            dfs(m-1,j,Atlantic);
        }
        for(int i = 0; i < m; ++i){
            dfs(i,n-1,Atlantic);
            dfs(i,0,Pacific);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(Pacific[i][j] && Atlantic[i][j]){
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }
    private void dfs(int x, int y,boolean[][] ocean){
        if(ocean[x][y]){
            return;
        }
        ocean[x][y] = true;
        for(int i =0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && heights[x][y] <= heights[nx][ny]){
                dfs(nx,ny,ocean);
            }
        }
    }
}
