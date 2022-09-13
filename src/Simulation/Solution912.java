package Simulation;

import java.util.Random;

/**
 * 912. 排序数组
 * @Author Hao Chen
 * @Create 2022/9/12 18:39
 */
public class Solution912 {
    Random rand = new Random();
    public int[] sortArray(int[] nums) {
        randomizedQuickSort(nums,0,nums.length-1);
        return nums;
    }
    private void randomizedQuickSort(int[] nums,int L,int R){
        if(L < R){
            int p = partition(nums,L,R);
            randomizedQuickSort(nums,L,p-1);
            randomizedQuickSort(nums,p+1,R);
        }
    }
    private int partition(int[] nums,int L,int R){
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
