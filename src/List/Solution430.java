package List;

/**
 * 430. 扁平化多级双向链表
 */
public class Solution430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node cur = head;
        while(cur != null){
            if(cur.child != null){
                Node temp = cur.next;
                Node childHead = flatten(cur.child);
                Node childEnd = getEnd(childHead);
                childHead.prev = cur;
                cur.next = childHead;
                if(temp != null){
                    temp.prev = childEnd;
                }
                childEnd.next = temp;
                cur.child = null;
                cur = temp;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    private Node getEnd(Node node){
        while(node != null && node.next != null){
            node = node.next;
        }
        return node;
    }
}

