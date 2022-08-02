package DP;
import Tree.TreeNode;
/**
 * 337. 打家劫舍 III
 * @Author Hao Chen
 * @Create 2022/8/1 19:23
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    /**
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2], 0 代表不偷，1 代表偷
     */
    private int[] dfs(TreeNode root){
        if(root == null) return new int[2];
        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
