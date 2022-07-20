package Heap;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * @Author Hao Chen
 * @Create 2022/7/19 22:19
 */
public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int w1 = pq.poll();
            int w2 = pq.poll();
            if(w1 == w2){
                continue;
            }else{
                pq.offer(w1-w2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
