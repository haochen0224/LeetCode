package DoublePointer;

/**
 * 面试题 16.16. 部分排序
 * @Author Hao Chen
 * @Create 2022/9/5 16:42
 */
public class Interview16_16 {
    public int[] subSort(int[] array) {
        if(array.length <= 1){
            return new int[]{-1,-1};
        }
        int n = array.length;
        int right = -1;
        int leftMax = array[0];
        for(int i = 0; i < n; ++i){
            if(array[i] >= leftMax){
                leftMax = array[i];
            }else{
                right = i;
            }
        }
        if(right == -1){
            return new int[]{-1,-1};
        }
        int left = -1;
        int minRight = array[n-1];
        for(int i = n-1; i >= 0; --i){
            if(array[i] <= minRight){
                minRight = array[i];
            }else{
                left = i;
            }
        }
        return new int[]{left,right};
    }
}
