package DP;

import java.util.Arrays;

/**
 * 152. 乘积最大子数组
 * @Author Hao Chen
 * @Create 2022/11/3 21:42
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] minDp = new int[n+1];
        int[] maxDp = new int[n+1];
        Arrays.fill(minDp,Integer.MAX_VALUE);
        Arrays.fill(maxDp,Integer.MIN_VALUE);
        maxDp[0] = 1;
        minDp[0] = 1;
        int res = nums[0];
        for(int i = 1; i <= n; ++i){
            maxDp[i] = Math.max(nums[i-1],Math.max(maxDp[i-1]*nums[i-1],minDp[i-1]*nums[i-1]));
            minDp[i] = Math.min(nums[i-1],Math.min(maxDp[i-1]*nums[i-1],minDp[i-1]*nums[i-1]));
            res = Math.max(res,maxDp[i]);
        }
        return res;
    }
}
