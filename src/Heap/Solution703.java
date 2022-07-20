package Heap;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * @Author Hao Chen
 * @Create 2022/7/19 22:28
 */
public class Solution703 {
}
class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
