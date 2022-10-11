package DP;

/**
 * 1567. 乘积为正数的最长子数组长度
 * @Author Hao Chen
 * @Create 2022/10/10 19:27
 */
public class Solution1567 {
    public int getMaxLen(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        if(nums[0] > 0){
            positive[0] = 1;
        }else if(nums[0] < 0){
            negative[0] = 1;
        }
        int res = positive[0];
        for(int i = 1; i < n; ++i){
            if(nums[i] > 0){
                positive[i] = positive[i-1] + 1;
                negative[i] = negative[i-1] > 0 ? negative[i-1] + 1 : 0;
            }else if(nums[i] < 0){
                positive[i] = negative[i-1] > 0 ? negative[i-1] + 1 : 0;
                negative[i] = positive[i-1] + 1;
            }else{
                positive[i] = 0;
                negative[i] = 0;
            }
            res = Math.max(res,positive[i]);
        }
        return res;
    }
}
