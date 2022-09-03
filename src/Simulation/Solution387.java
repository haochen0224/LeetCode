package Simulation;

/**
 * 387. 字符串中的第一个唯一字符
 * @Author Hao Chen
 * @Create 2022/7/26 17:21
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        int[] frq = new int[26];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            frq[ch-'a']++;
        }
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(frq[ch-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
