package COMPANY.ByteDance.Tree;

import COMPANY.ByteDance.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * @Author Hao Chen
 * @Create 2022/7/25 18:47
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        boolean isOrderLeft = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            Deque<Integer> layer = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(isOrderLeft){
                    layer.addLast(node.val);
                }else{
                    layer.addFirst(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            isOrderLeft = !isOrderLeft;
            res.add(new ArrayList<>(layer));
        }
        return res;
    }
}
