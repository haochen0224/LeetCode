package List;

/**
 * 876. 链表的中间结点
 */
public class Solution876 {
    /**
     * 如果有两个中间结点，返回第二个中间结点时，while(fast != null && fast.next != null)。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
