package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 * @Author Hao Chen
 * @Create 2022/9/12 20:44
 */
public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals,(a, b) -> a[0]-b[0]);
        pq.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] >= pq.peek()){
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}
