package BackTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * @Author Hao Chen
 * @Create 2022/8/27 21:37
 */
public class Solution77 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n <= 0 || k <= 0){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        dfs(1,n,k,path);
        return res;
    }
    private void dfs(int start,int n,int k,Deque<Integer> path){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; ++i){
            path.addLast(i);
            dfs(i+1,n,k,path);
            path.removeLast();
        }
    }
}
