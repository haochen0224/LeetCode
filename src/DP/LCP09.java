package DP;

/**
 * LCP 09. 最小跳跃次数
 * @Author Hao Chen
 * @Create 2022/9/21 19:22
 */
public class LCP09 {
    public int minJump(int[] jump) {
        if(jump.length == 0){
            return 0;
        }
        int[] dp = new int[jump.length]; //dp[i]表示从i位置跳出数组需要的最少步数
        dp[jump.length-1] = 1;
        for(int i = jump.length-2; i >= 0; --i){
            dp[i] = i+jump[i] >= jump.length ? 1 : dp[i+jump[i]]+1;
            for(int j = i+1; j < jump.length && dp[j] >= dp[i]+1; ++j){
                dp[j] = dp[i]+1;
            }
        }
        return dp[0];
    }
}
