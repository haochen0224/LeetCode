package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * @Author Hao Chen
 * @Create 2022/7/16 13:52
 */
public class Solution232 {
}
class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }

    public void in2out(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

    public int peek() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
