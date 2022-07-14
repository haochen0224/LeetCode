package Tree;

/**
 * 222. 完全二叉树的节点个数
 * @Author Hao Chen
 * @Create 2022/7/13 20:02
 */
public class Solution222 {
    // Set<TreeNode> visited;
    // int count = 0;
    // public int countNodes(TreeNode root) {
    //     visited = new HashSet<>();
    //     dfs(root);
    //     return count;
    // }
    // private void dfs(TreeNode root){
    //     if(root == null || visited.contains(root)){
    //         return;
    //     }
    //     ++count;
    //     visited.add(root);
    //     dfs(root.left);
    //     dfs(root.right);
    // }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while(node.left != null){
            ++level;
            node = node.left;
        }
        int low = 1 << level;
        int high = (1 <<(level+1)) - 1;
        while(low < high){
            int mid = low + (high-low+1)/2;
            if(exist(root,mid,level)){
                low = mid;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    private boolean exist(TreeNode root,int mid,int level){
        int bits = 1 << (level-1);
        while(root != null && bits > 0){
            if((bits & mid) == 0){
                root = root.left;
            }else{
                root = root.right;
            }
            bits >>= 1;
        }
        return root != null;
    }
}
