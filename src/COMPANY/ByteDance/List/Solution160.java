package COMPANY.ByteDance.List;

/**
 * 160. 相交链表
 * @Author Hao Chen
 * @Create 2022/8/7 22:11
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     Set<ListNode> set = new HashSet<>();
    //     ListNode p = headA;
    //     while(p != null){
    //         set.add(p);
    //         p = p.next;
    //     }
    //     ListNode res = headB;
    //     while(!set.contains(res) && res != null){
    //         res = res.next;
    //     }
    //     return res == null ? null : res;
    // }
}
