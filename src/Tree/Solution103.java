package Tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while(!queue.isEmpty()){
            Deque<Integer> layer = new LinkedList<>();
            int layerSize = queue.size();
            for(int i =  0; i < layerSize; ++i){
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
            res.add(new ArrayList<Integer>(layer));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
