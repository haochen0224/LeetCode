package List;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode reversedHead = reverseList(head);
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = reversedHead;
        ListNode preDelete = dummyNode;
        for(int i = 0; i < n-1; ++i){
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return reverseList(dummyNode.next);
    }
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
