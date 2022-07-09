package List;

/**
 * 82. 删除排序链表中的重复元素 II
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int repeatVal = cur.next.val;
                while(cur.next != null && cur.next.val == repeatVal){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
