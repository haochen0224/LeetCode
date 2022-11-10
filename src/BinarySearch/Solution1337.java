package BinarySearch;

import java.util.PriorityQueue;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * @Author Hao Chen
 * @Create 2022/11/8 12:48
 */
public class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        if(mat == null || mat.length == 0 || mat[0].length == 0){
            return new int[0];
        }
        int m = mat.length;
        int[] soldiers = new int[m];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> soldiers[a] == soldiers[b] ? b-a : soldiers[b]-soldiers[a]);
        for(int i = 0; i < m; ++i){
            int right = binarySearch(mat[i]);
            soldiers[i] = right;
        }
        for(int i = 0; i < m; ++i){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = k-1;
        while(!pq.isEmpty()){
            res[i--] = pq.poll();
        }
        return res;
    }
    private int binarySearch(int[] row){
        int left = 0, right = row.length-1;
        int res = row.length;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(row[mid] == 0){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}
