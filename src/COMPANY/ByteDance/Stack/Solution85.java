package COMPANY.ByteDance.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 85. 最大矩形
 * @Author Hao Chen
 * @Create 2022/8/3 18:09
 */
public class Solution85 {
    //O(mn)
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int res = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == '1'){
                    height[j] += 1;
                }else{
                    height[j] = 0;
                }
            }
            res = Math.max(res,largestRectangle(height));
        }
        return res;
    }
    private int largestRectangle(int[] height){
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1; i >= 0; --i){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for(int i = 0; i < n; ++i){
            res = Math.max(res,(right[i]-left[i]-1) * height[i]);
        }
        return res;
    }
}
