package List;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 */
public class Solution138 {
    Map<Node,Node> visitedNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        if(visitedNode.containsKey(head)){
            return visitedNode.get(head);
        }
        Node cloneNode = new Node(head.val);
        visitedNode.put(head,cloneNode);
        cloneNode.next = copyRandomList(head.next);
        cloneNode.random = copyRandomList(head.random);
        return cloneNode;
    }
}
