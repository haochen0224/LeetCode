package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 */
public class Solution114 {
//    public void flatten(TreeNode root) {
//        if(root == null){
//            return;
//        }
//        List<TreeNode> nodeList = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//        while(root != null || !stack.isEmpty()){
//            while(root != null){
//                nodeList.add(root);
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.poll();
//            root = root.right;
//        }
//        for(int i = 1; i < nodeList.size(); ++i){
//            TreeNode cur = nodeList.get(i);
//            TreeNode pre = nodeList.get(i-1);
//            pre.left = null;
//            pre.right = cur;
//        }
//    }
    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        dfs(nodeList,root);
        for(int i = 1; i < nodeList.size(); ++i){
            TreeNode pre = nodeList.get(i-1);
            TreeNode cur = nodeList.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }
    private void dfs(List<TreeNode> nodeList,TreeNode root){
        if(root == null){
            return;
        }
        nodeList.add(root);
        dfs(nodeList,root.left);
        dfs(nodeList,root.right);
    }

}
