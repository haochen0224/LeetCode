package Simulation;

/**
 * 409. 最长回文串
 * @Author Hao Chen
 * @Create 2022/7/26 17:32
 */
public class Solution409 {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(int i = 0; i < s.length(); ++i){
            freq[s.charAt(i)]++;
        }
        int count = 0;
        for(int i : freq){
            if(i % 2 == 1){
                ++count;
            }
        }
        //偶数个的字符全部可以保留，奇数个的字符只能保留一种，即每一种奇数个字符都拿掉一个，除了保留的那一种
        return count == 0 ? s.length() : s.length()-count+1;
    }
}
