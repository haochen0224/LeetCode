package COMPANY.ByteDance.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * @Author Hao Chen
 * @Create 2022/8/3 18:23
 */
public class Solution347 {
    //O(nlogk)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a)-map.get(b));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(pq.size() < k){
                pq.offer(num);
            }else{
                if(count > map.get(pq.peek())){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        int[] res = new int[pq.size()];
        for(int i = 0; i < res.length; ++i){
            res[i] = pq.poll();
        }
        return res;
    }
    //更快的实现：桶排序
    //O(n)
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int num : nums){
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//        List<Integer>[] bucket = new List[nums.length+1];
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//            int num = entry.getKey();
//            int count = entry.getValue();
//            if(bucket[count] == null){
//                bucket[count] = new ArrayList<>();
//            }
//            bucket[count].add(num);
//        }
//        List<Integer> resList = new ArrayList<>();
//        for(int i = bucket.length-1; i >= 0 && resList.size() < k; --i){
//            if(bucket[i] != null){
//                resList.addAll(bucket[i]);
//            }
//        }
//        int[] res = new int[resList.size()];
//        for(int i = 0; i < res.length; ++i){
//            res[i] = resList.get(i);
//        }
//        return res;
//    }
}
