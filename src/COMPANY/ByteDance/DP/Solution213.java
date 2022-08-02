package COMPANY.ByteDance.DP;

/**
 * 213. 打家劫舍 II
 * @Author Hao Chen
 * @Create 2022/8/1 19:01
 */
public class Solution213 {
    public int rob(int[] nums) {
        //如果偷窃了第一间房屋，则不能偷窃最后一间房屋，因此偷窃房屋的范围是第一间房屋到最后第二间房屋；
        //如果偷窃了最后一间房屋，则不能偷窃第一间房屋，因此偷窃房屋的范围是第二间房屋到最后一间房屋。
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[n];
        int a = 0, b = 0;
        //起点为第一间房屋
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < n-1; ++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        a = dp[n-2];
        //起点为第二间房屋
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for(int i = 3; i < n; ++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        b = dp[n-1];
        return Math.max(a,b);
    }
}
