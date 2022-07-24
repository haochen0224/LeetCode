package COMPANY.ByteDance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * @Author Hao Chen
 * @Create 2022/7/23 15:49
 */
public class Solution46 {
    List<List<Integer>> res;
    boolean[] visited;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        visited = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        dfs(path);
        return res;
    }
    private void dfs(Deque<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; ++i){
            if(!visited[i]){
                visited[i] = true;
                path.addLast(nums[i]);
                dfs(path);
                visited[i] = false;
                path.removeLast();
            }
        }
    }
}
