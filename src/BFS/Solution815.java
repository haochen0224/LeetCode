package BFS;

import java.util.*;

/**
 * 815. 公交路线
 * @Author Hao Chen
 * @Create 2022/9/24 19:50
 */
public class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = routes.length;
        boolean[][] edges = new boolean[n][n];
        for(int i = 0; i < n; ++i){
            for(int site : routes[i]){
                List<Integer> buses = map.getOrDefault(site,new ArrayList<>());
                for(int j : buses){
                    edges[i][j] = edges[j][i] = true;
                }
                buses.add(i);
                map.put(site,buses);
            }
        }
        int[] dis = new int[n];
        Arrays.fill(dis,-1);
        Queue<Integer> queue = new LinkedList<>();
        for(int bus : map.getOrDefault(source,new ArrayList<>())){
            dis[bus] = 1;
            queue.offer(bus);
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int y = 0; y < n; ++y){
                if(edges[x][y] && dis[y] == -1){
                    dis[y] = dis[x]+1;
                    queue.offer(y);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int bus : map.getOrDefault(target,new ArrayList<>())){
            if(dis[bus] != -1){
                res = Math.min(res,dis[bus]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
