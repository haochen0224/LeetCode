package BackTracking;

import java.util.*;

/**
 * 40. 组合总和 II
 * @Author Hao Chen
 * @Create 2022/8/27 21:49
 */
public class Solution40 {
    List<List<Integer>> res;
    boolean[] visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null || target < 0){
            return res;
        }
        visited = new boolean[candidates.length];
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates,0,path,target);
        return res;
    }
    private void dfs(int[] candidates,int startIndex,Deque<Integer> path,int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = startIndex; i < candidates.length; ++i){
            if(i > 0 && candidates[i] == candidates[i-1] && !visited[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            visited[i] = true;
            dfs(candidates,i+1,path,target-candidates[i]);
            path.removeLast();
            visited[i] = false;
        }
    }
}
