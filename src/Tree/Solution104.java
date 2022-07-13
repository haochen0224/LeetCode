package Tree;

/**
 * 104. 二叉树的最大深度
 */
public class Solution104 {
    int max;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(0,root);
        return max;
    }
    private void dfs(int count,TreeNode root){
        if(root == null){
            return;
        }
        ++count;
        max = Math.max(max,count);
        dfs(count,root.left);
        dfs(count,root.right);
    }
}
