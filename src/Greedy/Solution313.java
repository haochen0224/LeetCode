package Greedy;

import java.util.Arrays;

/**
 * 313. 超级丑数
 * @Author Hao Chen
 * @Create 2022/8/26 18:42
 */
public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n < 1 || primes == null){
            return 0;
        }
        int[] dp = new int[n+1];
        int m = primes.length;
        int[] nums = new int[m];
        int[] pointers = new int[m];
        Arrays.fill(nums,1);
        for(int i = 1; i <= n; ++i){
            int min = Arrays.stream(nums).min().getAsInt();
            dp[i] = min;
            for(int j = 0; j < m; ++j){
                if(nums[j] == min){
                    pointers[j]++;
                    nums[j] = dp[pointers[j]] * primes[j];
                    if(nums[j] < 0){
                        nums[j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        return dp[n];
    }
}
