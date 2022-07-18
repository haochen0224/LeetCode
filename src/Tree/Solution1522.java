package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1522. N 叉树的直径
 * @Author Hao Chen
 * @Create 2022/7/17 23:26
 */
public class Solution1522 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    int max;
    public int diameter(Node root) {
        max = 0;
        dfs(root);
        return max;
    }
    private int dfs(Node root){
        if(root == null){
            return 0;
        }
        int first = 0, second = 0;
        for(Node node : root.children){
            int cur = dfs(node);
            if(cur > first){
                second = first;
                first = cur;
            }else if(cur > second){
                second = cur;
            }
            max = Math.max(max,first+second);
        }
        return first + 1;
    }
}
