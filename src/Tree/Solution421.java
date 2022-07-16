package Tree;

/**
 *421. 数组中两个数的最大异或值
 * @Author Hao Chen
 * @Create 2022/7/15 20:36
 */
public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int res = 0;
        for(int i = 1; i < nums.length; ++i){
            trie.add(nums[i-1]);
            res = Math.max(res,trie.check(nums[i]));
        }
        return res;
    }

    class Trie{
        Trie left;
        Trie right;
        int HIGH_BIT;
        public Trie(){
            left = null;
            right = null;
            HIGH_BIT = 30;
        }
        public void add(int num){
            Trie node = this;
            for(int k = HIGH_BIT; k >= 0; --k){
                int bit = (num >> k) & 1;
                if(bit == 0){
                    if(node.left == null){
                        node.left = new Trie();
                    }
                    node = node.left;
                }else{
                    if(node.right == null){
                        node.right = new Trie();
                    }
                    node = node.right;
                }
            }
        }
        public int check(int num){
            Trie node = this;
            int res = 0;
            for(int k = HIGH_BIT; k >= 0; --k){
                int bit = (num >> k) & 1;
                if(bit == 0){
                    if(node.right != null){
                        res = res * 2 + 1;
                        node = node.right;
                    }else{
                        res = res * 2;
                        node = node.left;
                    }
                }else{
                    if(node.left != null){
                        res = res * 2 + 1;
                        node = node.left;
                    }else{
                        res = res * 2;
                        node = node.right;
                    }
                }
            }
            return res;
        }
    }
}
