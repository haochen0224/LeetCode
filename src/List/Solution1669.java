package List;

/**
 * 1669. 合并两个链表
 */
public class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        for(int i = 0; i < a-1; ++i){
            cur = cur.next;
        }
        ListNode prev = cur;
        for(int i = 0; i < b-a+2; ++i){
            cur = cur.next;
        }
        ListNode succ = cur;
        cur = list2;
        while(cur.next != null){
            cur = cur.next;
        }
        ListNode tail = cur;

        prev.next = list2;
        tail.next = succ;
        return list1;
    }
}
