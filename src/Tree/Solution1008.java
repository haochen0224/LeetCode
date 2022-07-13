package Tree;

/**
 * 1008. 前序遍历构造二叉搜索树
 */
public class Solution1008 {
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        if(preorder.length == 0){
            return null;
        }
        return buildTree(0,preorder.length-1);
    }
    private TreeNode buildTree(int left, int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        if(left == right){
            return root;
        }
        int index = left;
        while(index <= right && preorder[index] <= preorder[left]){
            ++index;
        }
        root.left = buildTree(left+1,index-1);
        root.right = buildTree(index,right);
        return root;
    }
}
