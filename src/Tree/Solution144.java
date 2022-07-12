package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class Solution144 {
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     dfs(res,root);
    //     return res;
    // }
    // private void dfs(List<Integer> res,TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     res.add(root.val);
    //     dfs(res,root.left);
    //     dfs(res,root.right);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return  res;
    }
}
