package Simulation;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * @Author Hao Chen
 * @Create 2022/9/5 17:09
 */
public class Solution215 {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelection(nums,0,n-1,n-k);
    }
    private int quickSelection(int[] nums,int L,int R,int index){
        int p = randomPartition(nums,L,R);
        if(p == index){
            return nums[p];
        }
        return p > index ? quickSelection(nums,L,p-1,index) : quickSelection(nums,p+1,R,index);
    }
    private int randomPartition(int[] nums,int L,int R){
        int randIndex = rand.nextInt(R-L+1)+L;
        swap(nums,randIndex,R);
        int pivot = nums[R];
        int i = L-1;
        for(int j = L; j < R; ++j){
            if(nums[j] <= pivot){
                swap(nums,++i,j);
            }
        }
        swap(nums,i+1,R);
        return i+1;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
