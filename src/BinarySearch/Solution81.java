package BinarySearch;

/**
 * 81. 搜索旋转排序数组 II
 * @Author Hao Chen
 * @Create 2022/7/22 19:55
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1){
            return nums[0] == target;
        }
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                ++left;
                --right;
            }else if(nums[left] <= nums[mid]){ //mid左边数组有序
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ //mid右边数组有序
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
