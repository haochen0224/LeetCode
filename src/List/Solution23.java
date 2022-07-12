package List;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */
public class Solution23 {
    class Status implements Comparable<Status>{
        int val;
        ListNode ptr;
        public Status(int val, ListNode ptr){
            this.val = val;
            this.ptr = ptr;
        }
        public int compareTo(Status s){
            return this.val - s.val;
        }
    }
    PriorityQueue<Status> pq = new PriorityQueue<>();
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        for(ListNode list : lists){
            if(list != null){
                pq.offer(new Status(list.val, list));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!pq.isEmpty()){
            Status cur = pq.poll();
            tail.next = cur.ptr;
            tail = tail.next;
            if(cur.ptr.next != null){
                ListNode next = cur.ptr.next;
                cur.ptr = next;
                pq.offer(new Status(next.val,next));
            }
        }
        return head.next;
    }
}
