package List;

/**
 * 234. 回文链表
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode firstHalfEnd = findMiddle(head);
        ListNode secondHalfHead = reverse(firstHalfEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        while(p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    /**
     * 当存在两个中间节点时，返回第一个，则 while(fast.next != null && fast.next.next != null)
     * @param head
     * @return
     */
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
