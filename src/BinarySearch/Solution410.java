package BinarySearch;

/**
 * 410. 分割数组的最大值
 * @Author Hao Chen
 * @Create 2022/9/23 17:29
 */
public class Solution410 {
    public int splitArray(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int left = 0, right = 0;
        for(int i = 0; i < n; ++i){
            left = Math.max(left,nums[i]);
            right += nums[i];
        }
        int res = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(check(nums,mid,k)){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
    private boolean check(int[] nums,int bucket,int k){
        int curSum = 0;
        int cnt = 1;
        for(int i = 0; i < nums.length; ++i){
            if(curSum+nums[i] > bucket){
                ++cnt;
                curSum = nums[i];
            }else{
                curSum += nums[i];
            }
        }
        return cnt <= k;
    }
}
