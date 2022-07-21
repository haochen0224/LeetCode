package Heap;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * @Author Hao Chen
 * @Create 2022/7/20 23:33
 */
public class Solution295 {
}

class MedianFinder {
    PriorityQueue<Integer> minQue; //大根堆，存储小于等于中位数的数
    PriorityQueue<Integer> maxQue;//小根堆，存储大于中位数的数
    public MedianFinder() {
        minQue = new PriorityQueue<>((a,b) -> b-a);
        maxQue = new PriorityQueue<>((a,b) -> a-b);
    }

    //保持minQue.size() = maxQue.size()+1 或者minQue.size() = maxQue.size()
    //这样的话 （1）当数字数量为奇数时，中位数就是 minQue.peek()，（2）当数字数量为偶数时，中位数为(minQue.peek()+maxQue.peek())/2.0
    public void addNum(int num) {
        if(minQue.isEmpty() || num <= minQue.peek()){
            minQue.offer(num);
            if(minQue.size() > maxQue.size()+1){
                maxQue.offer(minQue.poll());
            }
        }else{
            maxQue.offer(num);
            if(maxQue.size() > minQue.size()){
                minQue.offer(maxQue.poll());
            }
        }
    }

    public double findMedian() {
        if(minQue.size() > maxQue.size()){
            return minQue.peek();
        }
        return (minQue.peek()+maxQue.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
