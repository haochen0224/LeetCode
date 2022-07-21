package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 743. 网络延迟时间
 * @Author Hao Chen
 * @Create 2022/7/20 22:11
 */
public class Solution743 {
    //将问题转换为求从节点k出发到其他所有节点的距离的最大值，单源最短路径问题
    static int INF = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] edges = new List[n];
        for(int i = 0; i < n; ++i){
            edges[i] = new ArrayList<>();
        }
        for(int[] t : times){
            int u = t[0]-1, v = t[1]-1, w = t[2];
            edges[u].add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1]-b[1] : a[0]-b[0]);
        int[] dis = new int[n];
        Arrays.fill(dis,INF);
        dis[k-1] = 0;
        pq.offer(new int[]{k-1,0}); //{目的节点编号，到目的节点的距离}
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int time = cur[1];
            if(dis[x] < time){
                continue;
            }
            for(int[] e : edges[x]){
                int y = e[0], w = e[1];
                int d = dis[x] + w;
                if(d < dis[y]){
                    dis[y] = d;
                    pq.offer(new int[]{y,d});
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i){
            res = Math.max(res,dis[i]);
        }
        return res > INF/2 ? -1 : res;
    }
}
