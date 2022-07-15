package Tree;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * @Author Hao Chen
 * @Create 2022/7/14 14:46
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> rightMostNode = new HashMap<>();
        int maxDepth = -1;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> depthQueue = new LinkedList<>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            if(node != null){
                maxDepth = Math.max(maxDepth,depth);
                rightMostNode.put(depth,node.val);
                if(node.left != null){
                    nodeQueue.offer(node.left);
                    depthQueue.offer(depth+1);
                }
                if(node.right != null){
                    nodeQueue.offer(node.right);
                    depthQueue.offer(depth+1);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        // for(Map.Entry<Integer,Integer> entry : rightMostNode.entrySet()){
        //     res.add(entry.getValue());
        // }
        for(int i = 0; i <= maxDepth; ++i){
            res.add(rightMostNode.get(i));
        }
        return res;
    }
}
