package Tree;

/**
 * 543. 二叉树的直径
 */
public class Solution543 {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        if(root == null){
            return max;
        }
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max,left+right);
        return Math.max(left,right) + 1;
    }
}
