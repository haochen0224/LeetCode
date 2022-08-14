package DP;

/**
 * 494. 目标和
 * @Author Hao Chen
 * @Create 2022/8/13 21:39
 */
public class Solution494 {
    //设被加上"+"的数字和为sum(A)，被加上"-"的数字和为sum(B)
    //那么 sum(A) - sum(B) = target --> sum(A) = target + sum(B) --> 2sum(A) = target + sum  -->  sum(A) = (target+sum)/2
    //将原问题转换为分割子集，使得子集和为 (target+sum)/2
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < Math.abs(target) || (sum+target)%2 == 1){
            return 0;
        }
        int n = nums.length;
        int newSum = (target+sum)/2;
        int[][] dp = new int[n+1][newSum+1];
        dp[0][0] = 1; //nums中可以有负数，因此base cases 不能初始化为 dp[i][0] 全为1；而是只有dp[0][0]=1
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j <= newSum; ++j){
                if(j-nums[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][newSum];
    }
}
