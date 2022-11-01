package BinarySearch;

/**
 * 852. 山脉数组的峰顶索引
 * @Author Hao Chen
 * @Create 2022/11/1 18:42
 */
public class Solution852 {
    //峰顶也就是整个数组的唯一最大值
    public int peakIndexInMountainArray(int[] arr) {
        if(arr == null || arr.length < 3){
            return -1;
        }
        int n = arr.length;
        int left = 0, right = n-1;
        int res = -1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(arr[mid] > arr[mid+1]){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
    // static final int SUMMIT = 0;
    // static final int UP = 1;
    // static final int DOWN = -1;
    // public int peakIndexInMountainArray(int[] arr) {
    //     if(arr == null || arr.length == 0){
    //         return 0;
    //     }
    //     int n = arr.length;
    //     int left = 0, right = n-1;
    //     int res = 0;
    //     while(left <= right){
    //         int mid = left + ((right-left)>>1);
    //         if(check(mid,arr) == SUMMIT){
    //            return mid;
    //         }else if(check(mid,arr) == UP){
    //             left = mid + 1;
    //         }else{
    //             right = mid - 1;
    //         }
    //     }
    //     return res;
    // }
    // private int check(int checkPoint,int[] arr){
    //     for(int i = 0; i < checkPoint; ++i){
    //         if(arr[i] > arr[i+1]){
    //             return DOWN;
    //         }
    //     }
    //     for(int i = checkPoint; i < arr.length-1; ++i){
    //         if(arr[i] < arr[i+1]){
    //             return UP;
    //         }
    //     }
    //     return SUMMIT;
    // }
}
