package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * @Author Hao Chen
 * @Create 2022/7/14 1:04
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();
        queue1.offer(root);
        queue2.offer(1);
        int maxWidth = 0;
        while(!queue1.isEmpty()){
            int size = queue1.size();
            int tmpWidth = 0;
            int left = 0, right = 0;
            boolean isFirst = true;
            for(int i = 0; i < size; ++i){
                TreeNode node = queue1.poll();
                int pos = queue2.poll();
                if(isFirst){
                    isFirst = false;
                    left = pos;
                }
                right = pos;
                tmpWidth = Math.max(tmpWidth,right-left+1);
                if(node.left != null){
                    queue1.offer(node.left);
                    queue2.offer(pos*2);
                }
                if(node.right != null){
                    queue1.offer(node.right);
                    queue2.offer(pos*2+1);
                }
            }
            maxWidth = Math.max(tmpWidth,maxWidth);
        }
        return maxWidth;
    }
}
