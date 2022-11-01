package BinarySearch;

/**
 * 35. 搜索插入位置
 * @Author Hao Chen
 * @Create 2022/7/21 18:21
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int left = 0, right = n-1;
        int res = -1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res+1;
    }
}
