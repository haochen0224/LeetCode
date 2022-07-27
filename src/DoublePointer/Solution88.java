package DoublePointer;

/**
 * 88. 合并两个有序数组
 * @Author Hao Chen
 * @Create 2022/7/26 17:51
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1, tail = m+n-1;
        int cur;
        while(p1 >= 0 || p2 >= 0){
            if(p1 == -1){
                cur = nums2[p2--];
            }else if(p2 == -1){
                cur = nums1[p1--];
            }else if(nums1[p1] < nums2[p2]){
                cur = nums2[p2--];
            }else{
                cur = nums1[p1--];
            }
            nums1[tail--] = cur;
        }
    }
}
