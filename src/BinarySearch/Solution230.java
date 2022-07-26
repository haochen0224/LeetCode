package BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * 230. 二叉搜索树中第K小的元素
 * @Author Hao Chen
 * @Create 2022/7/25 19:19
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        return myBst.getKthElement(k);
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
        nodeCount.put(root,countNode(root.left)+countNode(root.right)+1);
        return nodeCount.get(root);
    }
    public int getKthElement(int k){
        TreeNode node = root;
        while(node != null){
            int left = nodeCount.getOrDefault(node.left,0);
            if(left == k-1){
                break;
            }else if(left < k){
                k -= left + 1;
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return node.val;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         List<Integer> list = new ArrayList<>();
//         dfs(list,root);
//         return list.get(k-1);
//     }
//     private void dfs(List<Integer> list,TreeNode root){
//         if(root == null){
//             return;
//         }
//         dfs(list,root.left);
//         list.add(root.val);
//         dfs(list,root.right);
//     }
// }