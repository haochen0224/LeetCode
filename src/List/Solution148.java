package List;

/**
 * 148. 排序链表
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while(left != null && right != null){
            if(left.val <= right.val){
                res.next = left;
                left = left.next;
            }else{
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = left != null ? left : right;
        return dummyNode.next;
    }
}
