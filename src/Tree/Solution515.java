package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * @Author Hao Chen
 * @Create 2022/7/14 17:51
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; ++i){
                TreeNode node = nodeQueue.poll();
                max = Math.max(max,node.val);
                if(node.left != null){
                    nodeQueue.offer(node.left);
                }
                if(node.right != null){
                    nodeQueue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
