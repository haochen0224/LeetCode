package DoublePointer;

/**
 * 125. 验证回文串
 * @Author Hao Chen
 * @Create 2022/7/26 18:16
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        StringBuffer sbuffer = new StringBuffer();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sbuffer.append(Character.toLowerCase(ch));
            }
        }
        int left = 0, right = sbuffer.length()-1;
        while(left < right){
            if(sbuffer.charAt(left) == sbuffer.charAt(right)){
                ++left;
                --right;
            }else{
                return false;
            }
        }
        return true;
    }
}
