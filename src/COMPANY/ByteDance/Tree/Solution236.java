package COMPANY.ByteDance.Tree;

import COMPANY.ByteDance.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 236. 二叉树的最近公共祖先
 * @Author Hao Chen
 * @Create 2022/7/26 14:01
 */
public class Solution236 {
    /**
     * 迭代法
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(root);
        queue.offer(root);
        //用queue层序遍历
        //用stack存储层序遍历的结果，栈底为root
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null){
                stack.push(cur.left);
                queue.offer(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
                queue.offer(cur.right);
            }
        }
        //自底向上对每个节点进行bfs，判断该节点或者该节点的孩子节点是否为p或q
        while(!stack.isEmpty()){
            TreeNode lowCom = stack.pop();
            int count = 0;
            if(lowCom.val == p.val || lowCom.val == q.val){
                ++count;
            }
            Queue<TreeNode> curQueue = new LinkedList<>();
            curQueue.offer(lowCom);
            while(!curQueue.isEmpty()){
                TreeNode curCom = curQueue.poll();
                if(curCom.left != null){
                    if(curCom.left.val == p.val || curCom.left.val == q.val){
                        ++count;
                    }
                    curQueue.offer(curCom.left);
                }
                if(curCom.right != null){
                    if(curCom.right.val == p.val || curCom.right.val == q.val){
                        ++count;
                    }
                    curQueue.offer(curCom.right);
                }
                if(count == 2){
                    return lowCom;
                }
            }
        }
        return null;
    }
}
