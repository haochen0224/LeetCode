package Tree;

/**
 * 112. 路径总和
 * @Author Hao Chen
 * @Create 2022/7/13 13:41
 */
public class Solution112 {
    boolean isExist = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        check(root,targetSum);
        return isExist;
    }
    private void check(TreeNode root,int targetSum){
        if(root == null || isExist){
            return;
        }
        if(root.val == targetSum && root.left == null && root.right == null){
            isExist = true;
            return;
        }
        check(root.left,targetSum-root.val);
        check(root.right,targetSum-root.val);
    }
}
