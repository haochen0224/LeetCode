package BackTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * @Author Hao Chen
 * @Create 2022/8/27 21:30
 */
public class Solution39 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        dfs(candidates,0,path,target);
        return res;
    }
    private void dfs(int[] candidates,int startIndex,Deque<Integer> path,int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || startIndex >= candidates.length){
            return;
        }
        for(int i = startIndex; i < candidates.length; ++i){
            path.addLast(candidates[i]);
            dfs(candidates,i,path,target-candidates[i]);
            path.removeLast();
        }
    }
}
