package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class Solution106 {
    Map<Integer,Integer> map;
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        this.inorder = inorder;
        this.postorder = postorder;
        int n = inorder.length;
        for(int i = 0; i < n; ++i){
            map.put(inorder[i],i);
        }
        return buildTree(0,n-1,0,n-1);
    }
    private TreeNode buildTree(int inOrderLeft,int inOrderRight,int postorderLeft,int postorderRight){
        if(inOrderLeft > inOrderRight){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderRight]);
        int inOrderRoot = map.get(root.val);
        int leftTreeSize = inOrderRoot - inOrderLeft;

        root.left = buildTree(inOrderLeft,inOrderRoot-1,postorderLeft,postorderLeft+leftTreeSize-1);
        root.right = buildTree(inOrderRoot+1,inOrderRight,postorderLeft+leftTreeSize,postorderRight-1);
        return root;
    }
}
