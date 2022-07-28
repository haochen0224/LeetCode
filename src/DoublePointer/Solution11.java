package DoublePointer;

/**
 * 11. 盛最多水的容器
 * @Author Hao Chen
 * @Create 2022/7/27 22:15
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int res = Integer.MIN_VALUE;
        while(left < right){
            int h = Math.min(height[left],height[right]);
            int w = right - left;
            res = Math.max(res,h*w);
            if(height[left] < height[right]){
                ++left;
            }else{
                --right;
            }
        }
        return res;
    }
}
