package DoublePointer;

/**
 * 424. 替换后的最长重复字符
 * @Author Hao Chen
 * @Create 2022/7/28 17:55
 */
public class Solution424 {
    public int characterReplacement(String s, int k) {
        if(s.length() < 2){
            return 1;
        }
        int[] freq = new int[26];
        char[] array = s.toCharArray();
        int left = 0, right = 0;
        int maxCount = 0;
        int res = 0;
        //把字串中除了最大出现次数字符之外的字符替换成最大出现次数字符
        while(right < s.length()){
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount,freq[s.charAt(right) - 'A']); //最大出现次数字符的出现次数
            ++right;
            if(right-left > maxCount+k){ //即使用完了k次替换机会，也不够覆盖掉其他字符
                freq[s.charAt(left) - 'A']--;
                ++left;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
