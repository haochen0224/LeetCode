package Tree;

/**
 * 572. 另一棵树的子树
 * @Author Hao Chen
 * @Create 2022/9/3 20:58
 */
public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return check(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    private boolean check(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null || root.val != subRoot.val){
            return false;
        }
        return check(root.left,subRoot.left) && check(root.right,subRoot.right);
    }
}
