package DP;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * @Author Hao Chen
 * @Create 2022/9/4 22:41
 */
public class Offer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '5')){
                if(i == 1){
                    dp[i] = 2;
                }else{
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()-1];
    }
}
