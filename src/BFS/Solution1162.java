package BFS;

import java.util.PriorityQueue;

/**
 * 1162. 地图分析
 * @Author Hao Chen
 * @Create 2022/8/20 17:38
 */
public class Solution1162 {
    //DP
    public int maxDistance(int[][] grid) {
        int INF = 0x3f3f3f3f;
        int n = grid.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                dp[i][j] = grid[i][j] == 1 ? 0 : INF;
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    continue;
                }
                if(i-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                }
                if(j-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                }
            }
        }
        for(int i = n-1; i >= 0; --i){
            for(int j = n-1; j >= 0; --j){
                if(grid[i][j] == 1){
                    continue;
                }
                if(i+1 < n){
                    dp[i][j] = Math.min(dp[i][j],dp[i+1][j]+1);
                }
                if(j+1 < n){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j+1]+1);
                }
            }
        }
        int res = -1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 0){
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res == INF ? -1 : res;
    }
    //Dijkstra
    // public int maxDistance(int[][] grid) {
    //     int INF = 0x3f3f3f3f;
    //     int[] dx = {-1,0,1,0};
    //     int[] dy = {0,1,0,-1};
    //     int n = grid.length;
    //     int[][] d = new int[n][n];
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
    //     for(int i = 0; i < n; ++i){
    //         for(int j = 0; j < n; ++j){
    //             d[i][j] = INF;
    //         }
    //     }
    //     for(int i = 0; i < n; ++i){
    //         for(int j = 0; j < n; ++j){
    //             if(grid[i][j] == 1){
    //                 d[i][j] = 0;
    //                 pq.offer(new int[]{0,i,j});
    //             }
    //         }
    //     }
    //     while(!pq.isEmpty()){
    //         int[] cur = pq.poll();
    //         int dis = cur[0];
    //         int x = cur[1];
    //         int y = cur[2];
    //         for(int i = 0; i < 4; ++i){
    //             int nx = x + dx[i];
    //             int ny = y + dy[i];
    //             if(nx >= 0 && nx < n && ny >=0 && ny < n){
    //                 if(dis+1 < d[nx][ny]){
    //                     d[nx][ny] = dis+1;
    //                     pq.offer(new int[]{dis+1,nx,ny});
    //                 }
    //             }
    //         }
    //     }
    //     int res = -1;
    //     for(int i = 0; i < n; ++i){
    //         for(int j = 0; j < n; ++j){
    //             if(grid[i][j] == 0){
    //                 res = Math.max(res,d[i][j]);
    //             }
    //         }
    //     }
    //     return res == INF ? -1 : res;
    // }
}
