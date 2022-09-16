package BFS;

import java.util.PriorityQueue;

/**
 * 407. 接雨水 II
 * @Author Hao Chen
 * @Create 2022/9/15 18:56
 */
public class Solution407 {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length <= 2 || heightMap[0].length <= 2){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(i == 0 || i == m-1 || j == 0 || j == n-1){
                    pq.offer(new int[]{i,j,heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], curHeight = cur[2];
            for(int i = 0; i < 4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                    if(curHeight > heightMap[nx][ny]){
                        res += curHeight - heightMap[nx][ny];
                    }
                    pq.offer(new int[]{nx,ny,Math.max(curHeight,heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
