package COMPANY.ByteDance;

/**
 * 4. 寻找两个正序数组的中位数
 * @Author Hao Chen
 * @Create 2022/7/21 14:52
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        if(totalLen % 2 == 1){
            int medianIndex = totalLen/2;
            return getKthElement(nums1,nums2,medianIndex+1);
        }else{
            int medianIndex1 = totalLen/2-1;
            int medianIndex2 = totalLen/2;
            return (getKthElement(nums1,nums2,medianIndex1+1) + getKthElement(nums1,nums2,medianIndex2+1)) / 2.0;
        }
    }
    private int getKthElement(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(true){
            if(index1 == len1){
                return nums2[index2+k-1];
            }
            if(index2 == len2){
                return nums1[index1+k-1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k/2;
            int newIndex1 = Math.min(index1+half,len1)-1;
            int newIndex2 = Math.min(index2+half,len2)-1;
            int pivot1 = nums1[newIndex1]; //pivot1和pivot2前面最多有k/2-1个元素
            int pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -= newIndex1 - index1 + 1; //每次排除k/2个元素（pivot之前的元素和pivot本身）
                index1 = newIndex1 + 1;
            }else{
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
