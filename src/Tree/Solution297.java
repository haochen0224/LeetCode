package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * @Author Hao Chen
 * @Create 2022/7/14 18:31
 */
public class Solution297 {
    public String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    public String rserialize(TreeNode root,String str){
        if(root == null){
            str += "None,";
            return str;
        }
        str += String.valueOf(root.val) + "," ;
        str = rserialize(root.left,str);
        str = rserialize(root.right,str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> strList = new LinkedList<>(Arrays.asList(strArray));
        return rdeserialize(strList);
    }
    public TreeNode rdeserialize(List<String> strList){
        if(strList.get(0).equals("None")){
            strList.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strList.get(0)));
        strList.remove(0);
        node.left = rdeserialize(strList);
        node.right = rdeserialize(strList);
        return node;
    }
}
