package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 */
public class Solution889 {
    int[] preorder;
    int[] postorder;
    Map<Integer,Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        int n = preorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            map.put(postorder[i],i);
        }
        return buildTree(0,n-1,0,n-1);
    }
    private TreeNode buildTree(int preOrderLeft,int preOrderRight,int postOrderLeft,int postOrderRight){
        if(preOrderLeft > preOrderRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        if(preOrderLeft == preOrderRight){
            return root;
        }
        int leftTreeRoot = map.get(preorder[preOrderLeft+1]);
        int leftTreeSize = leftTreeRoot - postOrderLeft + 1;
        root.left = buildTree(preOrderLeft+1,preOrderLeft+leftTreeSize,postOrderLeft,leftTreeRoot);
        root.right = buildTree(preOrderLeft+leftTreeSize+1,preOrderRight,leftTreeRoot+1,postOrderRight-1);
        return root;
    }
}
