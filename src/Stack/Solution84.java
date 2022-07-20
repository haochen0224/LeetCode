package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 * @Author Hao Chen
 * @Create 2022/7/19 19:53
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; //heights[i] 左边第一个比它小的
        int[] right = new int[n];//heights[i] 右边第一个比它小的
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1; i >= 0; --i){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for(int i = 0; i < n; ++i){
            //在(left[i],right[i])范围内所有位置都满足高度大于height[i]，可以组成矩形
            //宽度为right[i]-left[i]-1，要减掉端点
            res = Math.max(res,(right[i]-left[i]-1) * heights[i]);
        }
        return res;
    }
}
