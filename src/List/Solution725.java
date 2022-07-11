package List;

public class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            ++count;
        }
        int qoutient = count / k;
        int reminder = count % k;
        ListNode[] res = new ListNode[k];
        ListNode cur = head;
        for(int i = 0; i < k && cur != null; ++i){
            res[i] = cur;
            int partSize = qoutient + (i < reminder ? 1 : 0);
            for(int j = 1; j < partSize; ++j){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
