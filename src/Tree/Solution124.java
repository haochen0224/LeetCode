package Tree;

/**
 * 124. 二叉树中的最大路径和
 * @Author Hao Chen
 * @Create 2022/7/14 18:04
 */
public class Solution124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMost = Math.max(0,dfs(root.left));
        int rightMost = Math.max(0,dfs(root.right));
        //经过左子树的最大值路径，经过root，再经过右子树的最大值路径
        int path = root.val + leftMost + rightMost;
        max = Math.max(max,path);
        //向上回溯的时候只能返回左右两边的其中一条，因为从父节点下来的路径只能选择往左走或者往右走
        return root.val + Math.max(leftMost,rightMost);
    }
}
