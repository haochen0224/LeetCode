package DP;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * @Author Hao Chen
 * @Create 2022/7/21 19:15
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
/**
 * 更快的实现：二分查找
 */
//public int lengthOfLIS(int[] nums){
//    int[] top = new int[nums.length];
//    int piles = 0;
//    for(int i = 0; i < nums.length; ++i){
//        int poker = nums[i];
//        int left = 0, right = piles;
//        while(left < right){
//            int mid = left + ((right-left)>>1);
//            if(top[mid] > poker){
//                right = mid;
//            }else if(top[mid] < poker){
//                left = mid + 1;
//            }else{
//                right = mid;
//            }
//        }
//        if(left == piles){
//            ++piles;
//        }
//        top[left] = poker;
//    }
//    return piles;
//}
