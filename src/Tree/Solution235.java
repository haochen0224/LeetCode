package Tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 * @Author Hao Chen
 * @Create 2022/8/31 17:49
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        TreeNode res = root;
        while(true){
            if(p.val < res.val && q.val < res.val){
                res = res.left;
            }else if(p.val > res.val && q.val > res.val){
                res = res.right;
            }else{
                break;
            }
        }
        return res;
    }
}
