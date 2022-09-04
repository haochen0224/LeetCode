package DoublePointer;

/**
 * 680. 验证回文串 II
 * @Author Hao Chen
 * @Create 2022/9/3 20:28
 */
public class Solution680 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                ++left;
                --right;
            }else{
                return validPalindrome(s,left,right-1) || validPalindrome(s,left+1,right);
            }
        }
        return true;
    }
    private boolean validPalindrome(String s,int left,int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
