package COMPANY.ByteDance.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * @Author Hao Chen
 * @Create 2022/7/21 14:07
 */
public class Solution42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < height.length; ++i){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int curHeight = Math.min(height[left],height[i]) - height[top];
                int curWidth = i - left - 1;
                res += curHeight * curWidth;
            }
            stack.push(i);
        }
        return res;
    }
}
