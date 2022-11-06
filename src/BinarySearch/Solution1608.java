package BinarySearch;

/**
 * 1608. 特殊数组的特征值
 * @Author Hao Chen
 * @Create 2022/11/6 17:55
 */
public class Solution1608 {
    public int specialArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int left = 0, right = 0;
        for(int num : nums){
            right = Math.max(right,num);
        }
        while(left <= right){
            int mid = left + ((right-left)>>1);
            int checkRes = check(nums,mid);
            if(checkRes == mid){
                return mid;
            }else if(checkRes > mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    private int check(int[] nums,int mid){
        int cnt = 0;
        for(int num : nums){
            if(num >= mid){
                ++cnt;
            }
        }
        return cnt;
    }
}
