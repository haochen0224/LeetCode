package Simulation;

/**
 * 1160. 拼写单词
 * @Author Hao Chen
 * @Create 2022/9/20 17:33
 */
public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        if(words.length == 0 || chars.length() == 0){
            return 0;
        }
        int[] freq = new int[26];
        for(int i = 0; i < chars.length(); ++i){
            char ch = chars.charAt(i);
            freq[ch-'a']++;
        }
        int res = 0;
        int j = 0;
        for(int i = 0; i < words.length; ++i){
            String s = words[i];
            int[] freqCopy = freq.clone();
            for(; j < s.length(); ++j){
                char ch = s.charAt(j);
                if(freqCopy[ch-'a'] > 0){
                    freqCopy[ch-'a']--;
                }else{
                    break;
                }
            }
            if(j == s.length()){
                res += s.length();
            }
            j = 0;
        }
        return res;
    }
}
