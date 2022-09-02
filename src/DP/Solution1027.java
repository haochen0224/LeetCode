package DP;

/**
 * 1027. 最长等差数列
 * @Author Hao Chen
 * @Create 2022/9/1 21:30
 */
public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        if(nums == null){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][1001]; //dp[i][j] 表示以下标i结尾的等差为d的数列的最大长度
        int res = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d],dp[j][d]+1);
                res = Math.max(res,dp[i][d]);
            }
        }
        return res+1;
    }
}
