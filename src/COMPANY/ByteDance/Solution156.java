package COMPANY.ByteDance;

/**
 * 156. 上下翻转二叉树
 * @Author Hao Chen
 * @Create 2022/7/15 21:57
 */
public class Solution156 {
    TreeNode head = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        dfs(root,null);
        return head;
    }
    private void dfs(TreeNode cur,TreeNode pre){
        if(cur == null){
            return;
        }
        dfs(cur.left,cur);
        if(head == null){
            head = cur;
        }
        if(pre != null){
            pre.left = null;
            cur.left = pre.right;
            pre.right = null;
            cur.right = pre;
        }
    }
}
