package DP;

/**
 * 799. 香槟塔
 * @Author Hao Chen
 * @Create 2022/9/22 18:28
 */
public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0){
            return 0;
        }
        double[][] dp = new double[101][101];
        dp[0][0] = (double)poured;
        for(int i = 0; i <= query_row; ++i){
            for(int j = 0 ; j <= i; ++j){
                double pour = (dp[i][j]-1.0)/2.0;
                if(pour > 0){
                    dp[i+1][j] += pour;
                    dp[i+1][j+1] += pour;
                }
            }
        }
        return Math.min(1,dp[query_row][query_glass]);
    }
}
