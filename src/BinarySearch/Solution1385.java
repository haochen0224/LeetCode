package BinarySearch;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 * @Author Hao Chen
 * @Create 2022/11/2 18:59
 */
public class Solution1385 {
    static final int SMALL = 0;
    static final int LARGE = 1;
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        if(arr1 == null || arr2 == null){
            return 0;
        }
        Arrays.sort(arr2);
        int res = 0;
        for(int i = 0; i < arr1.length; ++i){
            int p1 = binarySearch(arr2,arr1[i],SMALL);
            int p2 = binarySearch(arr2,arr1[i],LARGE);
            if(Math.abs(arr1[i]-arr2[p1]) > d && Math.abs(arr1[i]-arr2[p2]) > d){
                ++res;
            }
        }
        return res;
    }
    private int binarySearch(int[] arr,int num,int compare){
        int left = 0, right = arr.length-1;
        int res = -1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(compare == SMALL){
                if(arr[mid] <= num){
                    res = mid;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(arr[mid] >= num){
                    res = mid;
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        if(res == -1 && compare == SMALL){
            return 0;
        }else if(res == -1 && compare == LARGE){
            return arr.length-1;
        }
        return res;
    }
}
