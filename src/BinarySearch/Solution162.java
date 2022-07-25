package BinarySearch;

/**
 * 162. 寻找峰值
 * @Author Hao Chen
 * @Create 2022/7/24 15:41
 */
public class Solution162 {
    /**
     *二分写法一
     */
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            //这种写法要先假设当前mid就是答案，防止之后的移动left或right产生的新mid覆盖掉正确答案
            //因此要先对当前mid做一些判断，若符合答案要求则直接返回

            //mid在两边边缘的情况
            if((mid == 0 && nums[mid] > nums[mid+1]) || (mid == nums.length-1) && nums[mid] > nums[mid-1]){
                return mid;
            }

            //mid在数组中间的情况
            if(mid > 0 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            //沿着大值走，一定能找到答案。因为大不了一直走走到边界，而题目假设nums[-1] = nums[n] = -∞
            //因此到达边界时只要满足当前值比相邻值大就可以了，即while循环中的第一次if判断
            if(nums[mid] < nums[mid+1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    /**
     * 二分写法二
     */
//    public int findPeakElement(int[] nums) {
//        int left = 0, right = nums.length-1;
//        while(left < right){
//            int mid = left + ((right-left)>>1);
//            if(nums[mid] < nums[mid+1]){
//                left = mid + 1;
//            }else{
//                right = mid;
//            }
//        }
//        return left;
//    }
}
