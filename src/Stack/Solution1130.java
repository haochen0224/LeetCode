package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1130. 叶值的最小代价生成树
 * @Author Hao Chen
 * @Create 2022/11/20 19:53
 */
public class Solution1130 {
    public int mctFromLeafValues(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for(int i = 0; i < n; ++i){
            while(!stack.isEmpty() && arr[i] >= stack.peek()){
                res += stack.pop() * Math.min(stack.peek(),arr[i]);
            }
            stack.push(arr[i]);
        }
        while(stack.size() > 2){
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
