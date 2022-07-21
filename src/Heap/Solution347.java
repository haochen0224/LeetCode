package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * @Author Hao Chen
 * @Create 2022/7/20 18:06
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(pq.size() == k){
                if(count > pq.peek()[1]){
                    pq.poll();
                    pq.offer(new int[]{num,count});
                }
            }else{
                pq.offer(new int[]{num,count});
            }
        }
        int[] res = new int[pq.size()];
        for(int i = 0; i < res.length; ++i){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}

/**
 * 更快的实现：桶排序。把元素出现的频率作为数组下标
 */
//class Solution347 {
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int num : nums){
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//        List<Integer>[] listArray = new List[nums.length+1];
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//            int num = entry.getKey();
//            int count = entry.getValue();
//            if(listArray[count] == null){
//                listArray[count] = new ArrayList<>();
//            }
//            listArray[count].add(num);
//        }
//        List<Integer> resList = new ArrayList<>();
//        for(int i = listArray.length-1; i >= 0 && resList.size()<k; --i){
//            if(listArray[i] != null){
//                resList.addAll(listArray[i]);
//            }
//        }
//
//        int[] res = new int[resList.size()];
//        for(int i = 0; i < resList.size(); ++i){
//            res[i] = resList.get(i);
//        }
//        return res;
//    }
//}
