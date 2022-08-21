package BackTracking;

import java.util.*;

/**
 * 90. 子集 II
 * @Author Hao Chen
 * @Create 2022/8/21 17:19
 */
public class Solution90 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        visited = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        dfs(0,nums,path);
        return res;
    }
    private void dfs(int startIndex,int[] nums,Deque<Integer> path){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; ++i){
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            visited[i] = true;
            dfs(i+1,nums,path);
            path.removeLast();
            visited[i] = false;
        }
    }
}
