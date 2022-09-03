package Simulation;

import java.util.Arrays;

/**
 * 204. 计数质数
 * @Author Hao Chen
 * @Create 2022/7/26 17:43
 */
public class Solution204 {
    public int countPrimes(int n) {
        if(n == 0){
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        int res = 0;
        for(int i = 2; i < n; ++i){
            if(isPrime[i]){
                ++res;
                if((long)i*i < n){
                    for(int j = i*i; j < n; j += i){
                        isPrime[j] = false;
                    }
                }
            }
        }
        return res;
    }
}
