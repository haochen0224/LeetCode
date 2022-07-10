package List;

/**
 * 328. 奇偶链表
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode oddList = new ListNode(0);
        ListNode evenList = new ListNode(0);
        ListNode oddPointer = oddList;
        ListNode evenPointer = evenList;
        ListNode cur = head;
        int index = 1;
        while(cur != null){
            if(index % 2 == 1){
                oddPointer.next = cur;
                oddPointer = oddPointer.next;
            }else{
                evenPointer.next = cur;
                evenPointer = evenPointer.next;
            }
            cur = cur.next;
            ++index;
        }
        ListNode evenHead = evenList.next;
        oddPointer.next = evenHead;
        evenPointer.next = null;
        evenList.next = null;
        return oddList.next;
    }
}
