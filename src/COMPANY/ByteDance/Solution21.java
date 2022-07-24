package COMPANY.ByteDance;

/**
 * 21. 合并两个有序链表
 * @Author Hao Chen
 * @Create 2022/7/23 15:42
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummyNode = new ListNode(0);
        ListNode merge = dummyNode;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                merge.next = l1;
                l1 = l1.next;
            }else{
                merge.next = l2;
                l2 = l2.next;
            }
            merge = merge.next;
        }
        if(l1 != null){
            merge.next = l1;
        }
        if(l2 != null){
            merge.next = l2;
        }
        return dummyNode.next;
    }
}
