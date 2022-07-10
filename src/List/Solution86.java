package List;

/**
 * 86. 分隔链表
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode large = largeHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                small.next = cur;
                cur = cur.next;
                small = small.next;
            }else{
                large.next = cur;
                cur = cur.next;
                large = large.next;
            }
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
