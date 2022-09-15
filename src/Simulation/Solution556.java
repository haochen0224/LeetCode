package Simulation;

/**
 * 556. 下一个更大元素 III
 * @Author Hao Chen
 * @Create 2022/9/14 20:47
 */
public class Solution556 {
    public int nextGreaterElement(int n) {
        char[] cn = Integer.toString(n).toCharArray();
        int i = cn.length-2;
        while(i >= 0 && cn[i] >= cn[i+1]){
            --i;
        }
        if(i < 0){
            return -1;
        }
        int j = cn.length-1;
        while(cn[i] >= cn[j]){
            --j;
        }
        swap(cn,i,j);
        reverse(cn,i+1,cn.length-1);
        long res = Long.parseLong(new String(cn));
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }
    private void swap(char[] nums,int i,int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(char[] nums,int left,int right){
        while(left < right){
            swap(nums,left++,right--);
        }
    }
}
