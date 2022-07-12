package List;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newl1 = reverseList(l1);
        ListNode newl2 = reverseList(l2);
        ListNode head = null, tail = null;
        int carry = 0;
        while(newl1 != null || newl2 != null){
            int n1 = newl1 != null ? newl1.val : 0;
            int n2 = newl2 != null ? newl2.val : 0;
            int sum = n1 + n2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(newl1 != null){
                newl1 = newl1.next;
            }
            if(newl2 != null){
                newl2 = newl2.next;
            }
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
        }
        return reverseList(head);
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
