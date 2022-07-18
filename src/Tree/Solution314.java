package Tree;

import java.util.*;

/**
 * 314. 二叉树的垂直遍历
 * @Author Hao Chen
 * @Create 2022/7/17 23:45
 */
public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<MyNode> queue = new LinkedList<>();
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        queue.offer(new MyNode(0,root));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                MyNode curNode = queue.poll();
                map.putIfAbsent(curNode.dis,new ArrayList<Integer>());
                List<Integer> curList = map.get(curNode.dis);
                curList.add(curNode.node.val);
                if(curNode.node.left != null){
                    queue.offer(new MyNode(curNode.dis-1,curNode.node.left));
                }
                if(curNode.node.right != null){
                    queue.offer(new MyNode(curNode.dis+1,curNode.node.right));
                }
            }
        }
        for(Integer dis : map.keySet()){
            res.add(map.get(dis));
        }
        return res;
    }
}
class MyNode {
    int dis;
    TreeNode node;

    public MyNode(int dis, TreeNode node) {
        this.dis = dis;
        this.node = node;
    }
}
