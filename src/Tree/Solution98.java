package Tree;

/**
 * 98. 验证二叉搜索树
 * @Author Hao Chen
 * @Create 2022/7/14 19:21
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {

        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean check(TreeNode root,long lower,long upper){
        if(root == null){
            return true;
        }
        if(root.val <= lower || root.val >= upper){
            return false;
        }
        return check(root.left,lower,root.val) && check(root.right,root.val,upper);
    }
}

