package BinarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 * @Author Hao Chen
 * @Create 2022/7/24 14:15
 */
public class Solution153 {
    /**
     * 二分写法一
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            res = Math.min(res,nums[mid]); //答案不一定出现在最后一个mid，因此设置变量保存所有nums[mid]中的最小值
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }

    /**
     * 二分写法二
     * @param nums
     * @return
     */
//    public int findMin(int[] nums) {
//        int left = 0, right = nums.length-1;
//        while(left < right){
//            int mid = left + ((right-left)>>1);
//            if(nums[mid] > nums[right]){
//                left = mid + 1;
//            }else{
//                right = mid;
//            }
//        }
//        return nums[left];
//    }
}

/**
 * 关于二分的两种写法：
 * （1） while(left < right){
 *     int mid = left + ((right-left)>>1);
 *     对mid的相关判断;
 *     ......
 *     left = mid + 1;
 *     ......
 *     right = mid;
 * }
 *
 * （2）while(left <= right){
 *     int mid = left + ((right-left)>>1);
 *     对mid的相关判断
 *     ......
 *     left = mid + 1;
 *     ......
 *     right = mid - 1;
 * }
 *
 * 考虑只有两个元素时的边界情况[a,b]，对于写法（1），mid=a之后，不管下一步left或者right怎么移动，都不会对a或b做最后一步判断
 * 因为循环条件为left<right，也就是说left或者right在下一步移动之后就直接退出循环。如果此时的b还需要判断，或者说b就是答案，则会漏判，程序出错
 * 写法（1）适合的题型：00000011111寻找第一个1
 * 对于写法（2），mid=a之后，若下一步移动left，则下一个mid=b，然后对该mid做最后一次判断，移动left或者right，结束循环。但此时若正确答案为a，
 * 则mid=b的操作会覆盖掉原来正确的答案，因此采用写法二时在得到mid之后不能马上移动left或者right，要设置变量保存当前mid的相关值。
 * 比如此题中设置res变量保存所有的nums[mid]中的最小值，因为答案不一定出现在最后一个nums[mid]。
 *
 * 因此对于写法一或者写法二的选择需要考虑对于边界情况[a,b]，需不需要对a或b做最后一次判断，通常来看写法二更加通用，但是一定要注意设置变量保存可能的
 * 答案，防止答案被之后的mid覆盖。比如此题中res = Math.min(res,nums[mid]); 比如寻找target的题型中if(nums[mid]==target) return; 相当于
 * 变相保存了答案。总之采用写法二时每一次int mid = left + ((right-left)>>1);之后要假设当前mid就是答案，然后做一些相关的操作。
 */
