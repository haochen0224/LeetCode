package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * @Author Hao Chen
 * @Create 2022/8/19 19:47
 */
public class Solution994 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean exist = false;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 2){
                    exist = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int res = 0;
        while(!queue.isEmpty()){
            ++res;
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for(int j = 0; j < 4; ++j){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                        if(grid[nx][ny] == 0 || grid[nx][ny] == 2){
                            continue;
                        }
                        if(grid[nx][ny] == 1){
                            grid[nx][ny] = 2;
                            queue.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        for(int[] row : grid){
            for(int i : row){
                if(i == 1){
                    return -1;
                }
            }
        }
        if(!exist){
            return 0;
        }
        return res-1;
    }
}
