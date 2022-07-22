package BinarySearch;

/**
 * 167. 两数之和 II - 输入有序数组
 * @Author Hao Chen
 * @Create 2022/7/21 18:48
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i = 0; i < n; ++i){
            int left = i+1, right = n-1; //避免重复元素，只在第一个数的右侧[i+1,n-1]寻找
            int newTarget = target - numbers[i];
            while(left <= right){
                int mid = left + (right-left)/2;
                if(numbers[mid] == newTarget){
                    return new int[]{i+1,mid+1};
                }
                if(numbers[mid] < newTarget){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return new int[0];
    }
}

/**
 * 更快的实现：双指针
 */
//public int[] twoSum(int[] numbers, int target) {
//    int n = numbers.length;
//    int left = 0, right = n-1;
//    while(left < right){
//        int sum = numbers[left] + numbers[right];
//        if(sum == target){
//            return new int[]{left+1,right+1};
//        }
//        if(sum > target){
//            --right;
//        }else{
//            ++left;
//        }
//
//    }
//    return new int[0];
//}