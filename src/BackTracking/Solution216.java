package BackTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * @Author Hao Chen
 * @Create 2022/8/28 18:52
 */
public class Solution216 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if(k < 0 || n < 0){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        dfs(k,n,path,1);
        return res;
    }
    private void dfs(int k,int n,Deque<Integer> path,int start){
        if(n == 0 && path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= 9; ++i){
            path.addLast(i);
            dfs(k,n-i,path,i+1);
            path.removeLast();
        }
    }
}
