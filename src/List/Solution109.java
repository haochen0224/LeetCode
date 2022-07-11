package List;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }
    private TreeNode buildTree(ListNode left, ListNode right){
        if(left == right){
            return null;
        }
        ListNode middleNode = findMiddle(left, right);
        TreeNode root = new TreeNode(middleNode.val);
        root.left = buildTree(left, middleNode);
        root.right = buildTree(middleNode.next,right);
        return root;
    }
    private ListNode findMiddle(ListNode left, ListNode right){
        ListNode slow = left;
        ListNode fast = left;
        while(fast != right && fast.next != right){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
