package DP;

/**
 * 238. 除自身以外数组的乘积
 * @Author Hao Chen
 * @Create 2022/11/13 18:55
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int n = nums.length;
        int[] prefix = new int[n]; //prefix[i] 表示除了 nums[i] 以外的前缀乘积
        prefix[0] = 1;
        for(int i = 1; i < n; ++i){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        int suffix = 1;
        int[] res = new int[n];
        for(int i = n-1; i >= 0; --i){
            res[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }
        return res;
    }
}
