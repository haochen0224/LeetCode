package Tree;

/**
 * 剑指 Offer 26. 树的子结构
 * @Author Hao Chen
 * @Create 2022/9/12 18:11
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }
    private boolean dfs(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return dfs(A.left,B.left) && dfs(A.right,B.right);
    }
}
