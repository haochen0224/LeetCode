package BinarySearch;

/**
 * 35. 搜索插入位置
 * @Author Hao Chen
 * @Create 2022/7/21 18:21
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
