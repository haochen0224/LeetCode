package DoublePointer;

/**
 * 392. 判断子序列
 * @Author Hao Chen
 * @Create 2022/9/23 22:27
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        int p1 = 0, p2 = 0;
        while(p1 < len1 && p2 < len2){
            if(s.charAt(p1) == t.charAt(p2)){
                ++p1;
                ++p2;
            }else{
                ++p2;
            }
        }
        return p1 == len1;
    }
}
