package COMPANY.ByteDance.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * @Author Hao Chen
 * @Create 2022/7/31 18:08
 */
public class Solution78 {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0,path);
        return res;
    }
    private void dfs(int startIndex,LinkedList<Integer> path){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; ++i){
            path.addLast(nums[i]);
            dfs(i+1,path);
            path.removeLast();
        }
    }
}
