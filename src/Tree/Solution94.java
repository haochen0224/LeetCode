package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *94. 二叉树的中序遍历
 */
public class Solution94 {
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     dfs(res,root);
    //     return res;
    // }
    // private void dfs(List<Integer> res, TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     dfs(res,root.left);
    //     res.add(root.val);
    //     dfs(res,root.right);
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
