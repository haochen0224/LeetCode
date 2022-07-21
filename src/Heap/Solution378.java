package Heap;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第 K 小的元素
 * @Author Hao Chen
 * @Create 2022/7/20 19:07
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i = 0; i < matrix.length; ++i){
            pq.offer(new int[]{matrix[i][0],i,0});
        }
        //行和列都是递增的，所以pq里的第一个元素一定是矩阵中最小的，然后检查该行的下个元素，迭代k次，堆顶的元素就是目标值
        for(int i = 0; i < k-1; ++i){
            int[] cur = pq.poll();
            if(cur[2]+1 < n){
                pq.offer(new int[]{matrix[cur[1]][cur[2]+1],cur[1],cur[2]+1});
            }
        }
        return pq.peek()[0];
    }
}

/**
 * 更快的实现：二分查找
 */
//class Solution378 {
//    public int kthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        int left = matrix[0][0];
//        int right = matrix[n-1][n-1];
//        while(left < right){
//            int mid = left + (right-left)/2;
//            if(check(matrix,mid,n,k)){
//                right = mid; //若<=mid的元素的数量>=k
//            }else{
//                left = mid + 1; //若<=mid的元素的数量<k
//            }
//        }
//        return left;
//    }
//    private boolean check(int[][] matrix,int mid,int n,int k){
//        int i = n-1;
//        int j = 0;
//        int num = 0;
//        while(i >= 0 && j < n){
//            if(matrix[i][j] <= mid){ //如果matrix[i][j] <= mid，说明该列所有数都<=mid
//                num += i+1;
//                ++j;
//            }else{
//                --i;
//            }
//        }
//        return num >= k;
//    }
//}
