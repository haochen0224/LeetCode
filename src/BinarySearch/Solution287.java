package BinarySearch;

/**
 * 287. 寻找重复数
 * @Author Hao Chen
 * @Create 2022/7/23 23:52
 */
public class Solution287 {
     public int findDuplicate(int[] nums) {
         int left = 1, right = nums.length-1;
         int ans = -1;
         while(left <= right){
             int mid = left + ((right-left)>>1);
             int count = 0; //数组中 <= mid的数的个数
             for(int num : nums){
                 if(num <= mid){
                     ++count;
                 }
             }
             if(count <= mid){
                 left = mid + 1;
             }else{
                 ans = mid; //对于重复元素i，count[i] > i，因此在移动右边界之前先保存当前mid，因为当前mid可能就是答案
                 right = mid - 1;
             }
         }
         return ans;
     }
/**
 * 更快的实现：快慢指针
  */
//    public int findDuplicate(int[] nums) {
//        int slow = 0, fast = 0;
//        slow = nums[slow];
//        fast = nums[nums[fast]];
//        while(slow != fast){
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        }
//        slow = 0;
//        while(slow != fast){
//            slow = nums[slow];
//            fast = nums[fast];
//        }
//        return slow;
//    }
}
