package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * @Author Hao Chen
 * @Create 2022/7/14 23:38
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode x = null;
        TreeNode y = null;
        dfs(list,root);
        for(int i = 0; i < list.size()-1; ++i){
            if(list.get(i).val > list.get(i+1).val){
                y = list.get(i+1);
                if(x == null){
                    x = list.get(i);
                }
            }
        }
        if(x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
    private void dfs(List<TreeNode> list,TreeNode root){
        if(root == null){
            return;
        }
        dfs(list,root.left);
        list.add(root);
        dfs(list,root.right);
    }
}
