package COMPANY.ByteDance.List;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @Author Hao Chen
 * @Create 2022/8/4 19:05
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode reverseHead = reverseList(head);
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = reverseHead;
        ListNode p = dummyNode;
        for(int i = 0; i < n-1; ++i){
            p = p.next;
        }
        p.next = p.next.next;
        return reverseList(dummyNode.next);
    }
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
