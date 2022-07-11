package List;

public class Solution369 {
    int carryBit = 0;
    public ListNode plusOne(ListNode head) {
        helper(head);
        if(carryBit == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }else{
            return head;
        }
    }
    private ListNode helper(ListNode node){
        if(node == null){
            return node;
        }
        if(node.next == null){
            node.val += 1;
            if(node.val >= 10){
                node.val -= 10;
                carryBit = 1;
            }
            return node;
        }
        node.next = helper(node.next);
        if(carryBit == 1){
            node.val += 1;
            carryBit = 0;
            if(node.val >= 10){
                node.val -= 10;
                carryBit = 1;
            }
        }
        return node;
    }
}
