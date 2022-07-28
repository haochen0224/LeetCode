package COMPANY.ByteDance.List;

/**
 * @Author Hao Chen
 * @Create 2022/7/21 13:35
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
