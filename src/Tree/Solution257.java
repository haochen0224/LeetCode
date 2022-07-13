package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class Solution257 {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs("",root);
        return res;
    }
    private void dfs(String path,TreeNode root){
        if(root == null){
            return;
        }
        StringBuffer pathToAdd = new StringBuffer(path);
        pathToAdd.append(Integer.toString(root.val));
        if(root.left == null && root.right == null){
            res.add(pathToAdd.toString());
        }else{
            pathToAdd.append("->");
            dfs(pathToAdd.toString(),root.left);
            dfs(pathToAdd.toString(),root.right);
        }
    }
}
