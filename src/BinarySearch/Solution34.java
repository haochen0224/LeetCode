package BinarySearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @Author Hao Chen
 * @Create 2022/7/21 21:31
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false)-1;
        if(leftIndex <= rightIndex && rightIndex <= nums.length-1 && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }
    private int binarySearch(int[] nums,int target,boolean lower){
        int left = 0, right = nums.length-1;
        int ans = nums.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target || lower && nums[mid] >= target){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
