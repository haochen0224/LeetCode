package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * @Author Hao Chen
 * @Create 2022/7/16 14:28
 */
public class Solution155 {
}
class MinStack {
    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    public MinStack() {
        mainStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        mainStack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
