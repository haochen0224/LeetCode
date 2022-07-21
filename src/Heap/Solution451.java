package Heap;

import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 * @Author Hao Chen
 * @Create 2022/7/20 19:46
 */
public class Solution451 {
    public String frequencySort(String s) {
        int[] cnt = new int[128];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            cnt[ch]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> cnt[b]-cnt[a]);
        for(int i = 0; i < 128; ++i){
            if(cnt[i] != 0){
                pq.offer(i);
            }
        }
        StringBuffer res = new StringBuffer();
        while(!pq.isEmpty()){
            int ch = pq.poll();
            int times = cnt[ch];
            while(times-- > 0){
                res.append((char)ch);
            }
        }
        return res.toString();
    }
}
