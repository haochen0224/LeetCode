package DP;

/**
 * 487. 最大连续1的个数 II
 * @Author Hao Chen
 * @Create 2022/11/4 16:58
 */
public class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n+1][2]; //dp[i][0]表示前 i 个数不翻转 0 时最长的连续 1 的长度
                                        //dp[i][1]表示前 i 个数翻转某个 0 时最长的连续 1 的长度
        int res = nums[0];
        for(int i = 1; i <= n; ++i){
            if(nums[i-1] == 1){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
            }else if(nums[i-1] == 0){
                dp[i][0] = 0; //如果不翻转该位置的 0，那么此时 1 已经不连续了，因此 dp[i][0] = 0
                dp[i][1] = dp[i-1][0] + 1;
            }
            res = Math.max(res,Math.max(dp[i][0],dp[i][1]));
        }
        return res;
    }

    //滑动窗口
//    public int findMaxConsecutiveOnes(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        int left = 0, right = 0, cnt = 0;
//        int res = 0;
//        int n = nums.length;
//        while(right < n){
//            while(right < n && cnt <= 1){
//                if(nums[right] == 0){
//                    ++cnt;
//                }
//                ++right;
//                if(cnt <= 1){
//                    res = Math.max(res,right-left);
//                }
//            }
//            while(left <= right && cnt > 1){
//                if(nums[left] == 0){
//                    --cnt;
//                }
//                ++left;
//            }
//        }
//        return res;
//    }
}
