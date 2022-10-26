package DP;

/**
 * 377. 组合总和 Ⅳ
 * @Author Hao Chen
 * @Create 2022/10/25 18:58
 */
public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; ++i){
            for(int num : nums){
                if(i-num >= 0){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
