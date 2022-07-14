package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. 求根节点到叶节点数字之和
 * @Author Hao Chen
 * @Create 2022/7/14 0:35
 */
public class Solution129 {
    List<Integer> numsList;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        numsList = new ArrayList<>();
        dfs(0,root);
        int res = 0;
        for(int num : numsList){
            res += num;
        }
        return res;
    }
    private void dfs(int curNum, TreeNode node){
        if(node == null){
            return;
        }
        curNum = curNum*10 + node.val;
        if(node.left == null && node.right == null){
            numsList.add(curNum);
            return;
        }
        dfs(curNum,node.left);
        dfs(curNum,node.right);
    }
}
