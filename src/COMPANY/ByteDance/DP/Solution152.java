package COMPANY.ByteDance.DP;

import java.util.Arrays;

/**
 * 152. 乘积最大子数组
 * @Author Hao Chen
 * @Create 2022/8/7 22:24
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        Arrays.fill(maxDp,Integer.MIN_VALUE);
        Arrays.fill(minDp,Integer.MAX_VALUE);
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; ++i){
            maxDp[i] = Math.max(nums[i],Math.max(maxDp[i-1]*nums[i],minDp[i-1]*nums[i]));
            minDp[i] = Math.min(nums[i],Math.min(maxDp[i-1]*nums[i],minDp[i-1]*nums[i]));
            res = Math.max(res,maxDp[i]);
        }
        return res;
    }
}
