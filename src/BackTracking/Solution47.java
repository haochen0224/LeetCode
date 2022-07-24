package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * @Author Hao Chen
 * @Create 2022/7/23 16:13
 */
public class Solution47 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        if(nums.length == 0){
            res.add(path);
            return res;
        }
        visited = new boolean[nums.length];
        Arrays.sort(nums); //排序数组，用于去重
        dfs(nums);
        return res;
    }
    private void dfs(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){ //递归树中同一枝的节点值可以重复，兄弟节点的值不能重复
                continue;
            }
            if(!visited[i]){
                path.addLast(nums[i]);
                visited[i] = true;
                dfs(nums);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
}
