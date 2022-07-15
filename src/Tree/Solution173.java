package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * @Author Hao Chen
 * @Create 2022/7/14 22:04
 */
public class Solution173 {

}
class BSTIterator {
    List<Integer> arr;
    int index;
    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        index = 0;
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        arr.add(root.val);
        inOrderTraversal(root.right);
    }

    public int next() {
        return arr.get(index++);
    }

    public boolean hasNext() {
        return index < arr.size();
    }
}