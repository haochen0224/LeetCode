package Simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * @Author Hao Chen
 * @Create 2022/9/4 22:57
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
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
