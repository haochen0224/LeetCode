package Greedy;

import java.util.Arrays;

/**
 * 870. 优势洗牌
 * @Author Hao Chen
 * @Create 2022/10/7 14:45
 */
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for(int i = 0; i < n; ++i){
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1,(i,j) -> nums1[i]-nums1[j]);
        Arrays.sort(idx2,(i, j) -> nums2[i]-nums2[j]);
        int left = 0, right = n-1;
        int[] res = new int[n];
        for(int i = 0; i < n; ++i){
            if(nums1[idx1[i]] > nums2[idx2[left]]){
                res[idx2[left]] = nums1[idx1[i]];
                ++left;
            }else{
                res[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return res;
    }
}
