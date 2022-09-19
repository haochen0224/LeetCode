package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 958. 二叉树的完全性检验
 * @Author Hao Chen
 * @Create 2022/9/18 18:35
 */
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        Node newRoot = new Node(1,root);
        List<Node> list = new ArrayList<>();
        list.add(newRoot);
        int i = 0;
        while(i < list.size()){
            Node node = list.get(i++);
            if(node.tnode.left != null){
                list.add(new Node(node.code*2,node.tnode.left));
            }
            if(node.tnode.right != null){
                list.add(new Node(node.code*2+1,node.tnode.right));
            }
        }
        return list.get(i-1).code == list.size();
    }
    class Node{
        int code;
        TreeNode tnode;
        public Node(){}
        public Node(int code,TreeNode tnode){
            this.code = code;
            this.tnode = tnode;
        }
    }
}

