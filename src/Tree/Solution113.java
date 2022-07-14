package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * @Author Hao Chen
 * @Create 2022/7/13 20:53
 */
public class Solution113 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root,targetSum,path);
        return res;
    }
    private void dfs(TreeNode root, int targetSum,LinkedList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        dfs(root.left,targetSum,path);
        dfs(root.right,targetSum,path);
        path.removeLast();
    }
}
