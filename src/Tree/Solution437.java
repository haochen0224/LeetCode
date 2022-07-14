package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * @Author Hao Chen
 * @Create 2022/7/13 21:39
 */
public class Solution437 {
    // public int pathSum(TreeNode root, int targetSum) {
    //     if(root == null){
    //         return 0;
    //     }

    //     int res = dfs(root,targetSum);
    //     res += pathSum(root.left,targetSum);
    //     res += pathSum(root.right,targetSum);
    //     return res;
    // }
    // private int dfs(TreeNode node,int targetSum){
    //     if(node == null){
    //         return 0;
    //     }
    //     int res = 0;
    //     if(node.val == targetSum){
    //         ++res;
    //     }
    //     res += dfs(node.left,targetSum-node.val);
    //     res += dfs(node.right,targetSum-node.val);
    //     return res;
    // }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);
        return dfs(root,prefixCount,targetSum,0);
    }
    private int dfs(TreeNode node,Map<Integer,Integer> prefixCount,int targetSum,int currSum){
        if(node == null){
            return 0;
        }
        int res = 0;
        currSum += node.val;
        res += prefixCount.getOrDefault(currSum-targetSum,0);
        prefixCount.put(currSum,prefixCount.getOrDefault(currSum,0)+1);
        res += dfs(node.left,prefixCount,targetSum,currSum);
        res += dfs(node.right,prefixCount,targetSum,currSum);
        prefixCount.put(currSum,prefixCount.getOrDefault(currSum,0)-1);
        return res;
    }
}
