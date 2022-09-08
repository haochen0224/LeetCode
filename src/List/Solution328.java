package List;

/**
 * 328. 奇偶链表
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
