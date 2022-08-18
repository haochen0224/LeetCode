package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 * @Author Hao Chen
 * @Create 2022/8/18 18:04
 */
public class Solution207 {
    int[] visitStatus;
    List<Integer>[] graph;
    boolean cycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visitStatus = new int[numCourses];
        graph = new List[numCourses];
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new ArrayList<Integer>();
        }
        cycle = false;
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        }
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
    private void dfs(int i){
        visitStatus[i] = 1;
        for(int y : graph[i]){
            if(visitStatus[y] == 0){
                dfs(y);
                if(cycle){
                    return;
                }
            }else if(visitStatus[y] == 1){
                cycle = true;
                return;
            }
        }
        visitStatus[i] = 2;
    }
}
