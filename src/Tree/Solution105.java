package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution105 {
    Map<Integer,Integer> map;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        for(int i = 0; i < n; ++i){
            map.put(inorder[i],i);
        }
        return buildTree(0,n-1,0,n-1);
    }
    private TreeNode buildTree(int preOrderLeft,int preOrderRight,int inOrderLeft,int inOrderRight){
        if(preOrderLeft > preOrderRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        int inOrderRoot = map.get(preorder[preOrderLeft]);
        int leftTreeSize = inOrderRoot - inOrderLeft;

        root.left = buildTree(preOrderLeft+1,preOrderLeft+leftTreeSize,inOrderLeft,inOrderRoot-1);
        root.right = buildTree(preOrderLeft+leftTreeSize+1,preOrderRight,inOrderRoot+1,inOrderRight);
        return root;
    }
}
