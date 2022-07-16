package List;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });

        for(ListNode list : lists){
            if(list != null){
                pq.offer(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                pq.offer(node.next);
                node = node.next;
            }
        }
        return head.next;
    }
}
