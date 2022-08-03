package COMPANY.ByteDance.Tree;

/**
 * 112. 路径总和
 * @Author Hao Chen
 * @Create 2022/8/2 20:42
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}
