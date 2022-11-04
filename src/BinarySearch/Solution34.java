package BinarySearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @Author Hao Chen
 * @Create 2022/7/21 21:31
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int start = -1;
        start = binarySearch(nums,target);
        if(start == -1){
            return new int[]{-1,-1};
        }
        int end = start;
        while(end+1 < nums.length && nums[end+1] == nums[end]){
            ++end;
        }
        return new int[]{start,end};
    }
    private int binarySearch(int[] nums,int target){
        int left = 0, right = nums.length-1;
        int res = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] >= target){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nums[res] == target ? res : -1;
    }
}
