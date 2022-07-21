package DFS;

import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 * @Author Hao Chen
 * @Create 2022/7/20 22:53
 */
public class Solution787 {
    static int INF = 0x3f3f3f3f;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,INF);
        dist[src] = 0;
        for(int i = 0; i < k+1; ++i){ //每轮迭代可能扩增一个从src到x的路径上的节点数量，因此迭代k+1次后从scr到dst的节点数量最多为k+1
            int[] clone = dist.clone(); //获取更新后的dist数组
            for(int[] f : flights){  //每轮迭代中遍历所有边，更新dist数组
                int u = f[0], v = f[1], w = f[2];
                dist[v] = Math.min(dist[v],clone[u]+w);
            }
        }
        return dist[dst] > INF/2 ? -1 : dist[dst];
    }
}
