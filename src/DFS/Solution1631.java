package DFS;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Hao Chen
 * @Create 2022/8/18 17:47
 */
public class Solution1631 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    static final int INF =  0x3f3f3f3f;
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[] dis = new int[m*n];
        boolean[] visited = new boolean[m*n];
        Arrays.fill(dis,INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        dis[0] = 0;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            if(visited[x*n+y]){
                continue;
            }
            if(x == m-1 && y == n-1){
                break;
            }
            visited[x*n+y] = true;
            for(int i = 0; i < 4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && Math.max(d,Math.abs(heights[x][y]-heights[nx][ny])) < dis[nx*n+ny]){
                    dis[nx*n+ny] = Math.max(d,Math.abs(heights[x][y]-heights[nx][ny]));
                    pq.offer(new int[]{nx,ny,dis[nx*n+ny]});
                }
            }
        }
        return dis[m*n-1];
    }
}
