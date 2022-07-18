package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 * @Author Hao Chen
 * @Create 2022/7/17 23:02
 */
public class Solution429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size; ++i){
                Node node = queue.poll();
                layer.add(node.val);
                if(node.children.size() > 0){
                    for(Node next : node.children){
                        queue.offer(next);
                    }
                }
            }
            res.add(layer);
        }
        return res;
    }
}

