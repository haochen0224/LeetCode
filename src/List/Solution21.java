package List;

/**
 * 21. 合并两个有序链表
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode mergeList = new ListNode(0);
        ListNode merge = mergeList;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                merge.next = p1;
                p1 = p1.next;
            }else{
                merge.next = p2;
                p2 = p2.next;
            }
            merge = merge.next;
        }
        if(p1 != null){
            merge.next = p1;
        }
        if(p2 != null){
            merge.next = p2;
        }
        return mergeList.next;
    }
}
