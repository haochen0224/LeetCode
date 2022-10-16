package BFS;

import java.util.*;

/**
 * 886. 可能的二分法
 * @Author Hao Chen
 * @Create 2022/10/15 14:40
 */
public class Solution886 {
    static final int UNCOLORED = 0;
    static final int RED = 1;
    static final int GREEN = 2;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n <= 0){
            return false;
        }
        List<Integer>[] graph = new List[n+1];
        for(int i = 0; i <= n; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < dislikes.length; ++i){
            graph[dislikes[i][0]].add(dislikes[i][1]);
            graph[dislikes[i][1]].add(dislikes[i][0]);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,UNCOLORED);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; ++i){
            if(color[i] == UNCOLORED){
                color[i] = RED;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    int nextColor = color[cur] == RED ? GREEN : RED;
                    for(int nx : graph[cur]){
                        if(color[nx] == UNCOLORED){
                            color[nx] = nextColor;
                            queue.offer(nx);
                        }else if(color[nx] != nextColor){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
