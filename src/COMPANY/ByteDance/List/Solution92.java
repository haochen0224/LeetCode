package COMPANY.ByteDance.List;

/**
 * 92. 反转链表 II
 * @Author Hao Chen
 * @Create 2022/7/28 14:41
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i = 0; i < left-1; ++i){
            pre = pre.next;
        }
        ListNode tail = pre;
        if(pre.next == null){
            return dummyNode.next;
        }
        ListNode nextHead = pre.next;
        for(int i = 0; i < right-left+1; ++i){
            tail = tail.next;
        }
        ListNode next = tail.next;
        tail.next = null;
        pre.next = reverseList(nextHead);
        nextHead.next = next;
        return dummyNode.next;
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
