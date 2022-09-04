package BitOperation;

/**
 * 540. 有序数组中的单一元素
 * @Author Hao Chen
 * @Create 2022/9/3 20:48
 */
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}
