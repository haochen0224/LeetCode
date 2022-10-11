package Simulation;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * @Author Hao Chen
 * @Create 2022/10/10 13:34
 */
public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1 == null || s2 == null){
            return true;
        }
        int n = s1.length();
        int[] freq = new int[26];
        int cnt = 0;
        for(int i = 0; i < n; ++i){
            ++freq[s1.charAt(i)-'a'];
            --freq[s2.charAt(i)-'a'];
            if(s1.charAt(i) != s2.charAt(i)){
                ++cnt;
            }
        }
        if(cnt > 2){
            return false;
        }
        for(int f: freq){
            if(f != 0){
                return false;
            }
        }
        return true;
    }
}
