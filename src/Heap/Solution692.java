package Heap;

import java.util.*;

/**
 * 692. 前K个高频单词
 * @Author Hao Chen
 * @Create 2022/7/15 19:59
 */
public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2){
                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(pq.size() > 0){
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
