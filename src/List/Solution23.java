package List;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    private ListNode merge(ListNode[] lists,int L,int R){
        if(L == R){
            return lists[L];
        }
        if(L > R){
            return null;
        }
        int mid = L + ((R-L)>>1);
        return mergeTwoLists(merge(lists,L,mid),merge(lists,mid+1,R));
    }
    private ListNode mergeTwoLists(ListNode list1,ListNode list2){
        if(list1 == null || list2 == null){
            return list1 != null ? list1 : list2;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode merge = dummyNode;
        ListNode p1 = list1;
        ListNode p2 = list2;
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
        return dummyNode.next;
    }
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists == null || lists.length == 0){
//            return null;
//        }
//        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
//        ListNode head = new ListNode(0);
//        ListNode tail = head;
//        for(ListNode list : lists){
//            if(list != null){
//                pq.offer(list);
//            }
//        }
//        while(!pq.isEmpty()){
//            ListNode node = pq.poll();
//            tail.next = node;
//            if(node.next != null){
//                pq.offer(node.next);
//            }
//            tail = tail.next;
//        }
//        return head.next;
//    }
}
