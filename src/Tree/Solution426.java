package Tree;

/**
 * 426. 将二叉搜索树转化为排序的双向链表
 * @Author Hao Chen
 * @Create 2022/9/1 22:56
 */
public class Solution426 {
    Node head = null;
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    private void dfs(Node root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre == null){
            head = root;
        }else{
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        dfs(root.right);
    }
}
