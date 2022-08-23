package TopologicalSorting;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 * @Author Hao Chen
 * @Create 2022/8/22 18:38
 */
public class Solution207 {
    int[] visitStatus;
    List<Integer>[] graph;
    boolean cycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visitStatus = new int[numCourses];
        graph = new List[numCourses];
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        }
        cycle = false;
        for(int i = 0; i < numCourses && !cycle; ++i){
            if(visitStatus[i] == 0){
                dfs(i);
                if(cycle){
                    return false;
                }
            }
        }
        return true;
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
        visitStatus[u] = 2;
    }
}
