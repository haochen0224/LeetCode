package COMPANY.ByteDance.Other;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * @Author Hao Chen
 * @Create 2022/8/8 21:02
 */
public class Offer51 {
    int count;
    public int reversePairs(int[] nums) {
        this.count = 0;
        merge(nums,0,nums.length-1);
        return count;
    }
    private void merge(int[] nums,int left,int right){
        int mid = left +((right-left)>>1);
        if(left < right){
            merge(nums,left,mid);
            merge(nums,mid+1,right);
            mergesort(nums,left,mid,right);
        }
    }
    private void mergesort(int[] nums,int left,int mid,int right){
        int[] mergeNums = new int[right-left+1];
        int temp1 = left, temp2 = mid+1;
        int index = 0;
        while(temp1 <= mid && temp2 <= right){
            if(nums[temp1] <= nums[temp2]){
                mergeNums[index++] = nums[temp1++];
            }else{
                count += mid - temp1 + 1;
                mergeNums[index++] = nums[temp2++];
            }
        }
        while(temp1 <= mid){
            mergeNums[index++] = nums[temp1++];
        }
        while(temp2 <= right){
            mergeNums[index++] = nums[temp2++];
        }
        for(int j = 0; j < mergeNums.length; ++j){
            nums[j+left] = mergeNums[j];
        }
    }
}
