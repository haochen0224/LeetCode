package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * @Author Hao Chen
 * @Create 2022/11/10 18:19
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for(int i = 0; i < n; ++i){
            f[i] = 1;
            int prev = i;
            for(int j = 0; j < i; ++j){
                if(nums[i] % nums[j] == 0){
                    if(f[j]+1 > f[i]){
                        f[i] = f[j] + 1;
                        prev = j;
                    }
                }
            }
            g[i] = prev;
        }
        int maxLen = -1, index = -1;
        for(int i = 0; i < n; ++i){
            if(f[i] > maxLen){
                maxLen = f[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(res.size() != maxLen){
            res.add(0,nums[index]);
            index = g[index];
        }
        return res;
    }
}
