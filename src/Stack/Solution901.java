package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 901. 股票价格跨度
 * @Author Hao Chen
 * @Create 2022/10/20 12:34
 */
public class Solution901 {
    class StockSpanner {
        Deque<int[]> stack;
        int index;
        public StockSpanner() {
            stack = new ArrayDeque<>();
            stack.push(new int[]{-1,Integer.MAX_VALUE});
            index = -1;
        }

        public int next(int price) {
            ++index;
            while(price >= stack.peek()[1]){
                stack.pop();
            }
            int res = index - stack.peek()[0];
            stack.push(new int[]{index,price});
            return res;
        }
    }
}
