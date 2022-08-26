package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的 K 对数字
 * @Author Hao Chen
 * @Create 2022/8/26 17:47
 */
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null){
            return null;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums1[a[0]]+nums2[a[1]] - nums1[b[0]]-nums2[b[1]]);
        int m = nums1.length;
        int n = nums2.length;
        for(int i = 0; i < Math.min(m,k); ++i){
            pq.offer(new int[]{i,0});
        }
        List<List<Integer>> res = new ArrayList<>();
        while(k-- > 0 && !pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int[] pair = pq.poll();
            list.add(nums1[pair[0]]);
            list.add(nums2[pair[1]]);
            res.add(list);
            if(pair[1]+1 < n){
                pq.offer(new int[]{pair[0],pair[1]+1});
            }
        }
        return res;
    }
}
