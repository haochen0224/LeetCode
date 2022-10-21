package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 * @Author Hao Chen
 * @Create 2022/7/16 23:42
 */
public class Solution1353 {
    public int maxEvents(int[][] events) {
        if(events == null){
            return 0;
        }
        Arrays.sort(events,(a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int day = 1;
        int i = 0;
        int res = 0;
        while(i < events.length || !pq.isEmpty()){
            //把开始于 day 的会议入队
            while(i < events.length && events[i][0] == day){
                pq.offer(events[i]);
                ++i;
            }
            //把已经结束的会议出队
            while(!pq.isEmpty() && pq.peek()[1] < day){
                pq.poll();
            }
            //参加结束时间最早的会议
            if(!pq.isEmpty()){
                pq.poll();
                ++res;
            }
            ++day; //进入下一天
        }
        return res;
    }
}
