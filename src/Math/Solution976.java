package Math;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * @Author Hao Chen
 * @Create 2022/8/29 18:05
 */
public class Solution976 {
    public int largestPerimeter(int[] nums) {
        if(nums == null){
            return 0;
        }
        Arrays.sort(nums);
        for(int i = nums.length-1; i >= 2; --i){
            if(nums[i-1]+nums[i-2] > nums[i]){
                return nums[i-1]+nums[i-2]+nums[i];
            }
        }
        return 0;
    }
}
