package DP;

/**
 * 413. 等差数列划分
 * @Author Hao Chen
 * @Create 2022/10/14 16:38
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        int n = nums.length;
        int res = 0;
        int[] dp = new int[n];
        for(int i = 2; i < n; ++i){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = dp[i-1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
    // public int numberOfArithmeticSlices(int[] nums) {
    //     if(nums == null || nums.length < 3){
    //         return 0;
    //     }
    //     int n = nums.length;
    //     int res = 0;
    //     for(int i = 0; i < n; ++i){
    //         int j = i+1;
    //         if(j == n) break;
    //         int d = nums[j] - nums[i];
    //         while(j+1 < n && nums[j+1]-nums[j] == d){
    //             ++j;
    //             if(j-i+1 >= 3){
    //                 ++res;
    //             }
    //         }
    //     }
    //     return res;
    // }
}
