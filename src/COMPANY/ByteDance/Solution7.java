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
            //因为当前运算还未结束，并且之后要 res*10，所以如果当前的res < Integer.MIN_VALUE/10 || res > Integer.MAX_VALUE/10
            //那么res*10必将不符合条件，因此return 0
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
