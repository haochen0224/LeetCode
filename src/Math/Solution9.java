package Math;

/**
 * 9. 回文数
 * @Author Hao Chen
 * @Create 2022/9/28 14:20
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int div = 1;
        while((x/div) >= 10){
            div *= 10;
        }
        while(x > 0){
            int left = x / div;
            int right = x % 10;
            if(left != right) return false;
            x = (x%div) / 10;
            div /= 100;
        }
        return true;
    }
}
