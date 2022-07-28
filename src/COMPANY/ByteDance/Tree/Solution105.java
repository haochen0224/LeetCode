package COMPANY.ByteDance.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @Author Hao Chen
 * @Create 2022/7/27 18:53
 */
public class Solution105 {
    int[] preorder;
    int[] inorder;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            map.put(inorder[i],i);
        }
        return build(0,n-1,0,n-1);
    }
    private TreeNode build(int preOrderLeft,int preOrderRight,int inOrderLeft,int inOrderRight){
        if(preOrderLeft > preOrderRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        int inOrderRootIndex = map.get(preorder[preOrderLeft]);
        int leftTreeSize = inOrderRootIndex - inOrderLeft;
        root.left = build(preOrderLeft+1,preOrderLeft+leftTreeSize,inOrderLeft,inOrderRootIndex-1);
        root.right = build(preOrderLeft+leftTreeSize+1,preOrderRight,inOrderRootIndex+1,inOrderRight);
        return root;
    }
}
