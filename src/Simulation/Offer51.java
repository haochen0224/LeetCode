package Simulation;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * @Author Hao Chen
 * @Create 2022/9/15 20:19
 */
public class Offer51 {
    int count = 0;
    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return count;
    }
    private void mergeSort(int[] nums,int L,int R){
        if(L < R){
            int mid = L + ((R-L)>>1);
            mergeSort(nums,L,mid);
            mergeSort(nums,mid+1,R);
            merge(nums,L,mid,R);
        }
    }
    private void merge(int[] nums,int L,int mid,int R){
        int p1 = L, p2 = mid+1;
        int i = L;
        while(p1 <= mid && p2 <= R){
            if(nums[p1] <= nums[p2]){
                temp[i++] = nums[p1++];
            }else{
                count += mid-p1+1;
                temp[i++] = nums[p2++];
            }
        }
        while(p1 <= mid){
            temp[i++] = nums[p1++];
        }
        while(p2 <= R){
            temp[i++] = nums[p2++];
        }
        for(int k = L; k <= R; ++k){
            nums[k] = temp[k];
        }
    }
}
