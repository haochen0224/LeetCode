package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 * @Author Hao Chen
 * @Create 2022/9/18 18:51
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2]){
                ++p1;
            }else if(nums1[p1] > nums2[p2]){
                ++p2;
            }else{
                list.add(nums1[p1]);
                ++p1;
                ++p2;
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(int num : list){
            res[i++] = num;
        }
        return res;
    }
}
