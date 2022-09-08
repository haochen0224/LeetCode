package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * @Author Hao Chen
 * @Create 2022/9/7 23:49
 */
public class Solution919 {
}
class CBTInserter {
    Queue<TreeNode> candidate;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        candidate = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(!(node.left != null && node.right != null)){
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode toInsert = new TreeNode(val);
        TreeNode res = candidate.peek();
        if(res.left == null){
            res.left = toInsert;
        }else{
            res.right = toInsert;
            candidate.poll();
        }
        candidate.offer(toInsert);
        return res.val;
    }

    public TreeNode get_root() {
        return root;
    }
}