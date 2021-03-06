package Tree;

/**
 * 617. 合并二叉树
 * @Author Hao Chen
 * @Create 2022/7/13 1:34
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val+root2.val);
        newRoot.left = mergeTrees(root1.left,root2.left);
        newRoot.right = mergeTrees(root1.right,root2.right);
        return newRoot;
    }
}
