package DP;

import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * @Author Hao Chen
 * @Create 2022/8/15 18:25
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j < i; ++j){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
