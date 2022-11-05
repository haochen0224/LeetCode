package BinarySearch;

/**
 * 1539. 第 k 个缺失的正整数
 * @Author Hao Chen
 * @Create 2022/11/5 18:54
 */
public class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        if(arr[0] > k){
            return k;
        }
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(arr[mid]-(mid+1) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left + k;
    }
    // public int findKthPositive(int[] arr, int k) {
    //     if(arr == null || arr.length == 0){
    //         return 0;
    //     }
    //     int num = 1;
    //     int i = 0;
    //     while(i < arr.length){
    //         if(arr[i] != num){
    //             --k;
    //             if(k == 0){
    //                 return num;
    //             }
    //             ++num;
    //         }else{
    //             ++num;
    //             ++i;
    //         }
    //     }
    //     --num;
    //     while(k > 0){
    //         ++num;
    //         --k;
    //     }
    //     return num;
    // }
}
