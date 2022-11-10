package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 * @Author Hao Chen
 * @Create 2022/11/9 20:02
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 < n2){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int left = 0;
        for(int i = 0; i < n2; ++i){
            int[] arr = binarySearch(nums1,nums2[i],left);
            int index = arr[0];
            left = arr[1]; //更新left
            if(index != -1 && nums1[index] == nums2[i]){
                list.add(nums1[index]);
                ++left;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        return res;
    }
    private int[] binarySearch(int[] nums1,int target,int left){
        int right = nums1.length-1;
        int res = -1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(nums1[mid] >= target){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{res,left}; //left是全局变量，要返回
    }
}
