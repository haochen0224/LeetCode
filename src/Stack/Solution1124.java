package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1124. 表现良好的最长时间段
 * @Author Hao Chen
 * @Create 2022/7/19 18:57
 */
public class Solution1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] scores = new int[n];
        int[] pre = new int[n+1];
        for(int i = 0; i < n; ++i){
            scores[i] = hours[i] > 8 ? 1 : -1;
        }
        for(int i = 1; i <= n; ++i){
            pre[i] = pre[i-1] + scores[i-1];
        }
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;

        //目标是找到pre[j]-pre[i] > 0 且 j-i最长
        //先构建单调递减的单调栈，因为若 pre = ......,-1,2,5,0,-3,...... 那么2,5,0对应的位置一定不会作为备选答案，因为在它们之前有-1，
        //同样的 pre[j]-pre[i] > 0 的情况下，选择-1对应的位置可以使得j-i更大。因此下一个备选答案只会是-3对应的位置。所以要构建单调递减的单调栈
        for(int i = 0; i <= n; ++i){
            if(stack.isEmpty() || pre[i] < pre[stack.peek()]){
                stack.push(i);
            }
        }

        //从后向前遍历pre数组，找到pre[j]-pre[i]>0且使得j-i最大的答案
        for(int i = n; i >= 0; --i){
            while(!stack.isEmpty() && pre[i] > pre[stack.peek()]){
                res = Math.max(res,i-stack.pop());
            }
        }
        return res;
    }
}
