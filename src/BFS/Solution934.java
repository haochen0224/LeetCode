package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. 最短的桥
 * @Author Hao Chen
 * @Create 2022/8/19 19:06
 */
public class Solution934 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int m;
    int n;
    int[][] grid;
    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;
        for(int i = 0; i < m; ++i){
            if(flag){
                break;
            }
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1 && !flag){
                    dfs(i,j,queue);
                    flag = true;
                    break;
                }
            }
        }
        int res = 0;
        while(!queue.isEmpty()){
            ++res;
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                //grid[x][y] = 2;
                for(int j = 0; j < 4; ++j){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                        if(grid[nx][ny] == 2){
                            continue;
                        }
                        if(grid[nx][ny] == 1){
                            return res;
                        }
                        queue.offer(new int[]{nx,ny});
                        grid[nx][ny] = 2;
                    }
                }
            }
        }
        return res;
    }
    private void dfs(int x, int y, Queue<int[]> queue){
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 2){
            return;
        }
        if(grid[x][y] == 0){
            queue.offer(new int[]{x,y});
            return;
        }
        grid[x][y] = 2;
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx,ny,queue);
        }
    }
}
