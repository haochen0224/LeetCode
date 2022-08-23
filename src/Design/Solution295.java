package Design;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * @Author Hao Chen
 * @Create 2022/8/23 18:13
 */
public class Solution295 {
}
class MedianFinder {
    PriorityQueue<Integer> minQue;
    PriorityQueue<Integer> maxQue;
    public MedianFinder() {
        minQue = new PriorityQueue<>((a,b) -> b-a);
        maxQue = new PriorityQueue<>((a,b) -> a-b);
    }

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
        }else{
            return (minQue.peek()+maxQue.peek()) / 2.0;
        }
    }
}