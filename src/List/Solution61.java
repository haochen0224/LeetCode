package List;

/**
 * 61. 旋转链表
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode countNode = dummyNode;
        while(countNode.next != null){
            countNode = countNode.next;
            ++count;
        }
        int reversedIndexOfNewHead = k % count;
        if(reversedIndexOfNewHead == 0){
            return head;
        }
        int indexOfNewHead = count - reversedIndexOfNewHead;
        ListNode pre = head;
        for(int i = 0; i < indexOfNewHead-1; ++i){
            pre = pre.next;
        }
        ListNode newHead = pre.next;
        pre.next = null;
        ListNode temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }
}
