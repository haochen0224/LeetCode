package COMPANY.ByteDance.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 * @Author Hao Chen
 * @Create 2022/8/9 18:21
 */
public class Solution207 {
    List<Integer>[] graph;
    int[] visitStatus; //三种节点访问状态：0：未访问；1：访问中；2：访问完成
    boolean cycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }
        graph = new List[numCourses];
        visitStatus = new int[numCourses];
        cycle = false;
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new ArrayList<>();
        }
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
    private void dfs(int  u){
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
