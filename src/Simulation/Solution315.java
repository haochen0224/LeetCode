package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * @Author Hao Chen
 * @Create 2022/9/15 21:04
 */
public class Solution315 {
    private int[] index;
    private int[] tempIndex;
    private int[] temp;
    private int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.index = new int[n];
        this.tempIndex = new int[n];
        this.temp = new int[n];
        this.ans = new int[n];
        for(int i = 0; i < n; ++i){
            index[i] = i;
        }
        mergeSort(nums,0,n-1);
        List<Integer> res = new ArrayList<>();
        for(int num : ans){
            res.add(num);
        }
        return res;
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
                temp[i] = nums[p1];
                tempIndex[i] = index[p1];
                ans[index[p1]] += (p2-mid-1);
                ++p1;
                ++i;
            }else{
                temp[i] = nums[p2];
                tempIndex[i] = index[p2];
                ++p2;
                ++i;
            }
        }
        while(p1 <= mid){
            temp[i] = nums[p1];
            tempIndex[i] = index[p1];
            ans[index[p1]] += (p2-mid-1);
            ++p1;
            ++i;
        }
        while(p2 <= R){
            temp[i] = nums[p2];
            tempIndex[i] = index[p2];
            ++p2;
            ++i;
        }
        for(int k = L; k <= R; ++k){
            index[k] = tempIndex[k];
            nums[k] = temp[k];
        }
    }
}
