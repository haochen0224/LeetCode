package BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 1319. 连通网络的操作次数
 * @Author Hao Chen
 * @Create 2022/8/18 19:51
 */
public class Solution1319 {
    List<Integer>[] graph;
    boolean[] visited;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        visited = new boolean[n];
        graph = new List[n];
        for(int i = 0; i < n; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] c : connections){
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        int res = 0;
        for(int i = 0; i < n; ++i){
            if(!visited[i]){
                dfs(i);
                ++res;
            }
        }
        return res-1;
    }
    private void dfs(int i){
        visited[i] = true;
        for(int y : graph[i]){
            if(!visited[y]){
                dfs(y);
            }
        }
    }
}
