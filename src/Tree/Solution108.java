package Tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * @Author Hao Chen
 * @Create 2022/7/14 19:03
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return buildTree(nums,0,nums.length-1);
    }
    private TreeNode buildTree(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        //int mid = (left + right)/2;    还剩两个节点时，mid选为左边的
        int mid = left + (right-left+1)/2; // 还剩两个节点时，mid选为右边的
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums,left,mid-1);
        root.right = buildTree(nums,mid+1,right);
        return root;
    }
}
