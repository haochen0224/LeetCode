package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 230. 二叉搜索树中第K小的元素
 * @Author Hao Chen
 * @Create 2022/7/14 23:15
 */
public class Solution230 {
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> nodeList = new ArrayList<>();
    //     dfs(nodeList,root);
    //     return nodeList.get(k-1);
    // }
    // private void dfs(List<Integer> nodeList,TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     dfs(nodeList,root.left);
    //     nodeList.add(root.val);
    //     dfs(nodeList,root.right);
    // }
    public int kthSmallest(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        return myBst.kthSmallest(k);
    }
}
class MyBst{
    TreeNode root;
    Map<TreeNode,Integer> nodeCount;
    public MyBst(TreeNode root){
        this.root = root;
        nodeCount = new HashMap<>();
        countNode(root);
    }
    private int countNode(TreeNode root){
        if(root == null){
            return 0;
        }
        nodeCount.put(root,1+countNode(root.left)+countNode(root.right));
        return nodeCount.get(root);
    }
    public int kthSmallest(int k){
        TreeNode node = root;
        while(node != null){
            int left = nodeCount.getOrDefault(node.left,0);
            if(left == k-1){
                break;
            }else if(left < k-1){
                node = node.right;
                k -= left + 1;
            }else{
                node = node.left;
            }
        }
        return node.val;
    }
}
