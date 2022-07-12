package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 */
public class Solution590 {
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(res,root);
        return res;
    }
    private void dfs(List<Integer> res,Node root){
        if(root == null){
            return;
        }
        for(Node node : root.children){
            dfs(res,node);
        }
        res.add(root.val);
    }
}
