package BackTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * @Author Hao Chen
 * @Create 2022/8/21 17:13
 */
public class Solution78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0 || nums == null){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        dfs(0,nums,path);
        return res;
    }
    private void dfs(int startIndex,int[] nums,Deque<Integer> path){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; ++i){
            path.addLast(nums[i]);
            dfs(i+1,nums,path);
            path.removeLast();
        }
    }
}
