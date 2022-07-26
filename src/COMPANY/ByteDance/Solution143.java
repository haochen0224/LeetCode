package COMPANY.ByteDance;

/**
 * 143. 重排链表
 * @Author Hao Chen
 * @Create 2022/7/25 14:38
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode firstHead = head;
        ListNode middle = findMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode secondHead = reverseList(next);
        ListNode p1 = firstHead;
        ListNode p2 = secondHead;
        while(p1 != null && p2 != null){
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;
            p1.next = p2;
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
