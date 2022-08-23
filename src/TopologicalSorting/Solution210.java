package TopologicalSorting;

import java.util.ArrayList;
import java.util.List;

/**
 * 210. 课程表 II
 * @Author Hao Chen
 * @Create 2022/8/22 18:51
 */
public class Solution210 {
    int[] visitStatus;
    List<Integer>[] graph;
    boolean cycle;
    int[] res;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visitStatus = new int[numCourses];
        index = numCourses-1;
        res = new int[numCourses];
        graph = new List[numCourses];
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        }
        for(int i = 0; i < numCourses; ++i){
            if(visitStatus[i] == 0){
                dfs(i);
                if(cycle){
                    return new int[0];
                }
            }
        }
        return res;
    }
    private void dfs(int u){
        visitStatus[u] = 1;
        for(int v : graph[u]){
            if(visitStatus[v] == 0){
                dfs(v);
                if(cycle){
                    return;
                }
            }else if(visitStatus[v] == 1){
                cycle = true;
                return;
            }
        }
        res[index--] = u;
        visitStatus[u] = 2;
    }
}
