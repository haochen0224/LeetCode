package List;

/**
 * 92. 反转链表 II
 */
public class Solution92 {
    /**
     * 穿针引线法，每次将next节点插入到待反转区域头部
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i = 0; i < left-1; ++i){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for(int i = 0; i < right-left; ++i){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
