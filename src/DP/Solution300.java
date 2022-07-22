package DP;

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
        int res = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; ++i){
            dp[i] = 1;
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
//public int lengthOfLIS(int[] nums) {
//    int[] tail = new int[nums.length];
//    int res = 0;
//    for(int num : nums){
//        int left = 0, right = res;
//        while(left < right){
//            int mid = left + (right-left)/2;
//            if(tail[mid] < num){
//                left = mid + 1;
//            }else{
//                right = mid;
//            }
//        }
//        tail[left] = num;
//        if(right == res){
//            ++res;
//        }
//    }
//    return res;
//}
