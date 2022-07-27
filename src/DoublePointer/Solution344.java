package DoublePointer;

/**
 * 344. 反转字符串
 * @Author Hao Chen
 * @Create 2022/7/26 18:19
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right){
            swap(s,left,right);
            ++left;
            --right;
        }
    }
    private void swap(char[] s,int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
