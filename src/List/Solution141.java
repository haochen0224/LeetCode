package List;

/**
 * 141. 环形链表
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead.next;
        ListNode slow = dummyHead;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
