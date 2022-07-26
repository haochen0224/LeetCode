package BinarySearch;

/**
 * 378. 有序矩阵中第 K 小的元素
 * @Author Hao Chen
 * @Create 2022/7/25 19:06
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];
        int ans = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(check(matrix,mid,k,n)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean check(int[][] matrix,int mid,int k, int n){
        int i = n-1;
        int j = 0;
        int num = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                num += i+1;
                ++j;
            }else{
                --i;
            }
        }
        return num >= k;
    }
    // public int kthSmallest(int[][] matrix, int k) {
    //     int n = matrix.length;
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
    //     for(int i = 0; i < n; ++i){
    //         pq.offer(new int[]{matrix[i][0],i,0});
    //     }
    //     for(int i = 0; i < k-1; ++i){
    //         int[] cur = pq.poll();
    //         if(cur[2]+1 < n){
    //             pq.offer(new int[]{matrix[cur[1]][cur[2]+1],cur[1],cur[2]+1});
    //         }
    //     }
    //     return pq.peek()[0];
    // }
}
