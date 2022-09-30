package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * @Author Hao Chen
 * @Create 2022/9/29 17:13
 */
public class Solution652 {
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null){
            return res;
        }
        dfs(root);
        return res;
    }
    private String dfs(TreeNode node){
        if(node == null){
            return " ";
        }
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(node.val).append("_");
        sbuffer.append(dfs(node.left)).append(dfs(node.right));
        String str = sbuffer.toString();
        map.put(str,map.getOrDefault(str,0)+1);
        if(map.get(str) == 2){
            res.add(node);
        }
        return str;
    }
}
