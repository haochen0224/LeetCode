package DP;

/**
 * 801. 使序列递增的最小交换次数
 * @Author Hao Chen
 * @Create 2022/10/9 17:43
 */
public class Solution801 {
    public int minSwap(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return 0;
        }
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][1] = 1;
        for(int i = 1; i < n; ++i){
            if(nums1[i-1] < nums1[i] && nums2[i-1] < nums2[i]){ //数组目前已经是有序的
                if(nums1[i-1] < nums2[i] && nums2[i-1] < nums1[i]){ //交换之后还是有序，可以交换也可以不交换
                    dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1]);
                    dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + 1;
                }else{ //交换之后就无序了，那么如果i位置交换，那么i-1位置也要交换，如果i位置不交换，那么i-1位置也不能交换
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1] + 1;
                }
            }else{//数组目前是无序的，那么如果i位置不交换，那么i-1位置必须交换，如果i位置交换，那么i-1位置不能交换
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + 1;
            }
        }
        return Math.min(dp[n-1][0],dp[n-1][1]);
    }
}
