package COMPANY.ByteDance;

/**
 * 7. 整数反转
 * @Author Hao Chen
 * @Create 2022/7/23 14:26
 */
public class Solution7 {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            if(res < Integer.MIN_VALUE/10 || res > Integer.MAX_VALUE/10){
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }
        return res;
    }
}
