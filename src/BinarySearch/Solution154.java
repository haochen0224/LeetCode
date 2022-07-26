package BinarySearch;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * @Author Hao Chen
 * @Create 2022/7/25 20:23
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            res = Math.min(res,nums[mid]);
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                ++left;
                --right;
            }else if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}
