package COMPANY.ByteDance;

/**
 * 11. 盛最多水的容器
 * @Author Hao Chen
 * @Create 2022/7/23 14:32
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1;
        while(left < right){
            res = Math.max((right-left) * Math.min(height[left],height[right]),res);
            if(height[left] <= height[right]){
                ++left;
            }else{
                --right;
            }
        }
        return res;
    }
}
