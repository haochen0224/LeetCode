package COMPANY.ByteDance.List;

/**
 * 24. 两两交换链表中的节点
 * @Author Hao Chen
 * @Create 2022/8/6 19:38
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = cur;
            pre.next = next;

            pre = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
