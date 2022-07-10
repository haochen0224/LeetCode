package List;

/**
 * 24. 两两交换链表中的节点
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;

            cur = cur.next;
            pre = pre.next.next;
        }
        return dummyNode.next;
    }
}
