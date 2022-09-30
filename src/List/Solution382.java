package List;

import java.util.Random;

/**
 * 382. 链表随机节点
 * @Author Hao Chen
 * @Create 2022/9/29 13:06
 */
public class Solution382 {
    ListNode head;
    Random rand;
    public Solution382(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        int i = 1;
        ListNode cur = head;
        int res = 0;
        while(cur != null){
            if(rand.nextInt(i) == 0){
                res = cur.val;
            }
            ++i;
            cur = cur.next;
        }
        return res;
    }
}
