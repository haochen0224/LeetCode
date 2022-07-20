package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 85. 最大矩形
 * @Author Hao Chen
 * @Create 2022/7/19 20:10
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int res = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }
            res = Math.max(res,largestRectangle(heights));
        }
        return res;
    }
    private int largestRectangle(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
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
            res = Math.max(res,(right[i]-left[i]-1) * heights[i]);
        }
        return res;
    }
}
