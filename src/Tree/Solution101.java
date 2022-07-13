package Tree;

/**
 * 101. 对称二叉树
 */
public class Solution101 {
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        isSymmetric = true;
        if(root == null){
            return false;
        }
        check(root.left,root.right);
        return isSymmetric;
    }
    private void check(TreeNode left, TreeNode right){
        if((left == null && right == null) || !isSymmetric){
            return;
        }
        if(left == null || right == null || left.val != right.val){
            isSymmetric = false;
            return;
        }
        check(left.left,right.right);
        check(left.right,right.left);
    }
}
