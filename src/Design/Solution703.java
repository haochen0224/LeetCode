package Design;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * @Author Hao Chen
 * @Create 2022/8/23 17:53
 */
public class Solution703 {
}
class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a,b) -> a-b);
        for(int i = 0; i < nums.length; ++i){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }

    public int add(int val) {
        if(pq.size() < k){
            pq.offer(val);
        }else if(val > pq.peek()){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}