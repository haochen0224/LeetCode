package BinarySearch;

/**
 * 300. 最长递增子序列
 * @Author Hao Chen
 * @Create 2022/7/21 19:48
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length]; //tails[k] 的值代表长度为k+1的子序列的尾部元素值
        int res = 0; //当前tails的长度
        for(int num : nums){
            int left = 0, right = res;
            //找到tails中第一个比num大的元素，并用num替换
            while(left < right){
                int mid = left + (right-left)/2;
                if(tail[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            tail[left] = num;
            if(right == res){ //tails中没有元素比num大，最长递增子序列长度+1
                ++res;
            }
        }
        return res;
    }

    /**
     * dp做法
     */
    // public int lengthOfLIS(int[] nums) {
    //     if(nums.length == 0){
    //         return 0;
    //     }
    //     int[] dp = new int[nums.length];
    //     int res = 1;
    //     dp[0] = 1;
    //     for(int i = 1; i < nums.length; ++i){
    //         dp[i] = 1;
    //         for(int j = 0; j < i; ++j){
    //             if(nums[i] > nums[j]){
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //         res = Math.max(res,dp[i]);
    //     }
    //     return res;
    // }
}
