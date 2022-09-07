package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1293. 网格中的最短路径
 * @Author Hao Chen
 * @Create 2022/9/6 20:48
 */
public class Solution1293 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1){
            return 0;
        }
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,k});
        visited[0][0][k] = true;
        int step = 0;
        while(!queue.isEmpty()){
            ++step;
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1], restK = cur[2];
                for(int i = 0; i < 4; ++i){
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n){
                        if(grid[nextX][nextY] == 0 && !visited[nextX][nextY][restK]){
                            if(nextX == m-1 && nextY == n-1){
                                return step;
                            }
                            visited[nextX][nextY][restK] = true;
                            queue.offer(new int[]{nextX,nextY,restK});
                        }else if(grid[nextX][nextY] == 1 && restK > 0 && !visited[nextX][nextY][restK-1]){
                            visited[nextX][nextY][restK-1] = true;
                            queue.offer(new int[]{nextX,nextY,restK-1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
