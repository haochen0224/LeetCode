package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. 判断二分图
 * @Author Hao Chen
 * @Create 2022/8/19 19:24
 */
public class Solution785 {
    static final int UNCOLORED = 0;
    static final int RED = 1;
    static final int GREEN = 2;
    int[] color;
    boolean valid;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color,UNCOLORED);
        valid = true;
        for(int i = 0; i < n && valid; ++i){
            if(color[i] == UNCOLORED){
                color[i] = RED;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    int nextColor = color[node] == RED ? GREEN : RED;
                    for(int j : graph[node]){
                        if(color[j] == UNCOLORED){
                            queue.offer(j);
                            color[j] = nextColor;
                        }else if(color[j] != nextColor){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
