package COMPANY.ByteDance;

/**
 * 25. K 个一组翻转链表
 * @Author Hao Chen
 * @Create 2022/7/22 14:21
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode start = prev.next;
        ListNode end = prev;
        while(end.next != null){
            for(int i = 0; i < k; ++i){
                end = end.next;
                if(end == null){
                    return dummyNode.next;
                }
            }
            ListNode next = end.next;
            end.next = null;
            prev.next = reverseList(start);
            start.next = next;
            prev = start;
            end = start;
            start = start.next;
        }
        return dummyNode.next;
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
