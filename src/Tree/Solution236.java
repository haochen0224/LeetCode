package Tree;

/**
 * 236. 二叉树的最近公共祖先
 * @Author Hao Chen
 * @Create 2022/7/13 18:14
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
//    迭代
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        queue.offer(root);
//        stack.push(root);
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0; i < size; ++i){
//                TreeNode cur = queue.poll();
//                if(cur.left != null){
//                    queue.offer(cur.left);
//                    stack.push(cur.left);
//                }
//                if(cur.right != null){
//                    queue.offer(cur.right);
//                    stack.push(cur.right);
//                }
//            }
//        }
//        while(!stack.isEmpty()){
//            TreeNode lowCom = stack.pop();
//            int count = 0;
//            if(lowCom.val == p.val || lowCom.val == q.val){
//                ++count;
//            }
//            Queue<TreeNode> curQueue = new LinkedList<>();
//            curQueue.offer(lowCom);
//            while(!curQueue.isEmpty()){
//                int size = curQueue.size();
//                for(int i = 0; i < size; ++i){
//                    TreeNode curNode = curQueue.poll();
//                    if(curNode.left != null){
//                        if(curNode.left.val == p.val || curNode.left.val == q.val){
//                            ++count;
//                        }
//                        curQueue.offer(curNode.left);
//                    }
//                    if(curNode.right != null){
//                        if(curNode.right.val == p.val || curNode.right.val == q.val){
//                            ++count;
//                        }
//                        curQueue.offer(curNode.right);
//                    }
//                    if(count == 2){
//                        return lowCom;
//                    }
//                }
//            }
//        }
//        return null;
//    }
}
