package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 907. 子数组的最小值之和
 * @Author Hao Chen
 * @Create 2022/10/27 14:02
 */
public class Solution907 {
    static final int MOD = (int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; ++i){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1; i >= 0; --i){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n;
            }else{
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        long res = 0;
        for(int i = 0; i < n; ++i){
            res = (res + (long)(i-left[i])*(right[i]-i)*arr[i]) % MOD;
        }
        return (int)res;
    }
}
