package DP;

/**
 * 72. 编辑距离
 * @Author Hao Chen
 * @Create 2022/8/12 19:33
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; ++i){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; ++j){
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(word1.charAt(i-1) == word2.charAt(j-1)){ //末尾字符能匹配上，则直接判断前面的
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //末尾字符匹配不上
                    //1. 删除word1的i位置字符，那么dp[i][j] = dp[i-1][j]
                    //2. 给word1的i位置插入word2的j位置的字符，那么dp[i][j] = dp[i][j-1]
                    //3. 把word1的i位置替换为word2的j位置字符，那么dp[i][j] = dp[i-1][j-1]
                    //三种情况取最小值
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }
}
