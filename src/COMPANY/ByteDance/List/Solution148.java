package COMPANY.ByteDance.List;

/**
 * 148. 排序链表
 * @Author Hao Chen
 * @Create 2022/7/31 17:34
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
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        while(left != null && right != null){
            if(left.val <= right.val){
                p.next = left;
                left = left.next;
            }else{
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;
        return dummyNode.next;
    }
}
