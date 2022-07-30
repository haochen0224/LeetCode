package DP;

/**
 * 53. 最大子数组和
 * @Author Hao Chen
 * @Create 2022/7/29 20:23
 */
public class Solution53 {
    // public int maxSubArray(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     dp[0] = nums[0];
    //     int res = dp[0];
    //     for(int i = 1; i < n; ++i){
    //         dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
    //         res = Math.max(res,dp[i]);
    //     }
    //     return res;
    // }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int res = pre;
        for(int i = 1; i < n; ++i){
            pre = Math.max(nums[i],pre+nums[i]);
            res = Math.max(res,pre);
        }
        return res;
    }
}
