package Tree;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 * @Author Hao Chen
 * @Create 2022/7/17 23:11
 */
public class Solution559 {
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
    public int maxDepth(Node root) {

        return dfs(0,root);
    }
    private int dfs(int depth, Node root){
        if(root == null){
            return 0;
        }
        int max = 0;
        ++depth;
        for(Node node : root.children){
            max = Math.max(max,dfs(depth,node));
        }
        return max+1;
    }
}
