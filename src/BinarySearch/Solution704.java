package BinarySearch;

/**
 * 704. 二分查找
 * @Author Hao Chen
 * @Create 2022/7/21 18:14
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
