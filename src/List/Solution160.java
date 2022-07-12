package List;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = headA;
        while(cur != null){
            visited.add(cur);
            cur = cur.next;
        }
        ListNode find = headB;
        while(find != null){
            if(visited.contains(find)){
                return find;
            }
            find = find.next;
        }
        return null;
    }
}
