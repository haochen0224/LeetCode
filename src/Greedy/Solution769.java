package Greedy;

/**
 * 769. 最多能完成排序的块
 * @Author Hao Chen
 * @Create 2022/10/12 12:25
 */
public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int m = 0;
        int res = 0;
        for(int i = 0; i < n; ++i){
            m = Math.max(m,arr[i]);
            if(m == i){
                ++res;
            }
        }
        return res;
    }
}
