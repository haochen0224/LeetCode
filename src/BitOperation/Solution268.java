package BitOperation;

/**268. 丢失的数字
 * @Author Hao Chen
 * @Create 2022/10/2 12:46
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int num :nums){
            xor ^= num;
        }
        for(int i = 0; i <= n; ++i){
            xor ^= i;
        }
        return xor;
    }
}
