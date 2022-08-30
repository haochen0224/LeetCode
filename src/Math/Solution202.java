package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * @Author Hao Chen
 * @Create 2022/8/29 18:11
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    private int getNext(int n){
        int res = 0;
        while(n > 0){
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}
