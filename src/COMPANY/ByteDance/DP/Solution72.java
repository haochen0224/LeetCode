package COMPANY.ByteDance.DP;

/**
 * 72. 编辑距离
 * @Author Hao Chen
 * @Create 2022/7/29 18:25
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        //dp[i][j] 表示将word1前i个字符转换到word2前j个字符需要的步骤
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; ++i){
            dp[i][0] = dp[i-1][0] + 1;
        }
        for(int j = 1; j <= len2; ++j){
            dp[0][j] = dp[0][j-1] + 1;
        }
        //dp[i-1][j]+1: 在状态dp[i-1][j]表示的两个字符串中，将word1添加一个字符
        //dp[i][j-1]+1: 在状态dp[i][j-1]表示的两个字符串中，将word2添加一个字符
        //dp[i-1][j-1]+1: 在状态dp[i-1][j-1]表示的两个字符串中，将word1修改一个字符（等价于将word2修改一个字符）
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                //若当前位置的word1和word2字符相同，不用做增删改操作，直接参考dp[i-1][j-1]
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
