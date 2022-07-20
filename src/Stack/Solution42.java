package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * @Author Hao Chen
 * @Create 2022/7/19 19:33
 */
public class Solution42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < height.length; ++i){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                //stack.isEmpty()说明刚刚弹出来的已经是之前栈里最大的了，说明它之前的坐标已经处理完成雨水的计算了，否则栈里一定有比它还大的
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left],height[i]) - height[top];
                res += curWidth * curHeight;
            }
            stack.push(i);
        }
        return res;
    }
}
