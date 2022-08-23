package BFS;

import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 * @Author Hao Chen
 * @Create 2022/8/23 16:48
 */
public class Solution787 {
    static final int INF = 0x3f3f3f3f;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis,INF);
        dis[src] = 0;
        for(int i = 0; i <= k; ++i){
            int[] clone = dis.clone();
            for(int[] f : flights){
                int u = f[0], v = f[1], w = f[2];
                if(clone[u] + w < dis[v]){
                    dis[v] = clone[u] + w;
                }
            }
        }
        return dis[dst] > INF/2 ? -1 : dis[dst];
    }
}
