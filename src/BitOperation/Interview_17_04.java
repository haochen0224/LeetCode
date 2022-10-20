package BitOperation;

/**
 * 面试题 17.04. 消失的数字
 * @Author Hao Chen
 * @Create 2022/10/19 18:12
 */
public class Interview_17_04 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        for(int i = 0; i <= n; ++i){
            xor ^= i;
        }
        return xor;
    }
}
