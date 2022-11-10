package BinarySearch;

import java.util.Arrays;

/**
 * 1346. 检查整数及其两倍数是否存在
 * @Author Hao Chen
 * @Create 2022/11/8 13:09
 */
public class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length == 0){
            return false;
        }
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < n; ++i){
            if(binarySearch(arr,i)){
                return true;
            }
        }
        return false;
    }
    private boolean binarySearch(int[] arr,int index){
        int left = arr[index] >= 0 ? index + 1 : 0;
        int right = arr[index] >= 0 ? arr.length-1 : index-1;
        if(left > right){
            return false;
        }
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(arr[mid] == 2*arr[index]){
                return true;
            }
            if(arr[mid] < 2*arr[index]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
