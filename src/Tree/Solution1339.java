package Tree;

/**
 * 1339. 分裂二叉树的最大乘积
 * @Author Hao Chen
 * @Create 2022/9/8 0:24
 */
public class Solution1339 {
    long res = 0, sum = 0;
    int MOD = (int)1e9+7;
    public int maxProduct(TreeNode root) {
        sum = sumTree(root);
        nodeStack(root);
        return (int)(res%MOD);
    }
    private long sumTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }
    private long nodeStack(TreeNode root){
        if(root == null){
            return 0;
        }
        long split = root.val + nodeStack(root.left) + nodeStack(root.right);
        res = Math.max(res,split * (sum-split));
        return split;
    }
}
