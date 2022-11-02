package DP;

/**
 * 265. 粉刷房子 II
 * @Author Hao Chen
 * @Create 2022/11/2 19:37
 */
public class Solution265 {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n+1][k]; //dp[i][j] 表示第 i 个房屋粉刷为 j 号颜色时，粉刷前 i 个房屋的最小花费
        for(int i = 1; i <= n; ++i){ //初始化从 i=1 开始，因为 i=0 这一行应该初始化为0
            for(int j = 0; j < k; ++j){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i <= n; ++i){ //枚举第 i 个房屋
            for(int j = 0; j < k; ++j){ //枚举当前房屋的粉刷颜色
                for(int p = 0; p < k; ++p){ //枚举前一个房屋的粉刷颜色
                    if(p == j){ //前一个房屋的粉刷颜色和当前房屋相同时，跳过
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][p] + costs[i-1][j]); //取最小值
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; ++i){
            res = Math.min(res,dp[n][i]); //在最后一行中取最小值，作为结果
        }
        return res;
    }
}
