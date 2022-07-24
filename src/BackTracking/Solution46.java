package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * @Author Hao Chen
 * @Create 2022/7/23 16:17
 */
public class Solution46 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] visited;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        if(nums.length == 0){
            return res;
        }
        visited = new boolean[nums.length];
        dfs(nums);
        return res;
    }
    private void dfs(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; ++i){
            if(!visited[i]){
                visited[i] = true;
                path.addLast(nums[i]);
                dfs(nums);
                visited[i] = false;
                path.removeLast();
            }
        }
    }
}
