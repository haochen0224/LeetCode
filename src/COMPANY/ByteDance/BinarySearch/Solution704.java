package COMPANY.ByteDance.BinarySearch;

/**
 * 704. 二分查找
 * @Author Hao Chen
 * @Create 2022/8/3 18:36
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
