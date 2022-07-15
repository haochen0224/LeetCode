package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * @Author Hao Chen
 * @Create 2022/7/14 17:46
 */
public class Solution116 {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Deque<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            for(int i = 0; i < size; ++i){
                Node node = nodeQueue.poll();
                if(i < size - 1){
                    node.next = nodeQueue.peek();
                }
                if(node.left != null){
                    nodeQueue.offer(node.left);
                }
                if(node.right != null){
                    nodeQueue.offer(node.right);
                }
            }
        }
        return root;
    }
    // public Node connect(Node root) {
    //     if(root == null){
    //         return root;
    //     }
    //     Deque<Node> nodeQueue = new LinkedList<>();
    //     Deque<Integer> depthQueue = new LinkedList<>();
    //     nodeQueue.offer(root);
    //     depthQueue.offer(0);
    //     while(!nodeQueue.isEmpty()){
    //         Node node = nodeQueue.poll();
    //         int depth = depthQueue.poll();
    //         if(nodeQueue.isEmpty() || depthQueue.peek() != depth){
    //             node.next = null;
    //         }else{
    //             node.next = nodeQueue.peek();
    //         }

    //         if(node.left != null){
    //             nodeQueue.offer(node.left);
    //             depthQueue.offer(depth+1);
    //         }
    //         if(node.right != null){
    //             nodeQueue.offer(node.right);
    //             depthQueue.offer(depth+1);
    //         }
    //     }
    //     return root;
    // }
}
