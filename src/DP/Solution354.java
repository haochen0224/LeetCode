package DP;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * @Author Hao Chen
 * @Create 2022/8/11 18:41
 */
public class Solution354 {
    //DP 解法,超时
//    public int maxEnvelopes(int[][] envelopes) {
//        int n = envelopes.length;
//        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
//        int[] dp = new int[n];
//        Arrays.fill(dp,1);
//        int res = 1;
//        for(int i = 1; i < n; ++i){
//            for(int j = 0; j < i; ++j){
//                if(envelopes[i][1] > envelopes[j][1]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//            }
//            res = Math.max(res,dp[i]);
//        }
//        return res;
//    }
    //二分查找
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes,(a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i){
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS(nums);
    }
    private int lengthOfLIS(int[] nums){
        int[] top = new int[nums.length];
        int piles = 0;
        for(int i = 0; i < nums.length; ++i){
            int poker = nums[i];
            int left = 0, right = piles;
            while(left < right){
                int mid = left + ((right-left)>>1);
                if(top[mid] > poker){
                    right = mid;
                }else if(top[mid] < poker){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if(left == piles){
                ++piles;
            }
            top[left] = poker;
        }
        return piles;
    }
}
