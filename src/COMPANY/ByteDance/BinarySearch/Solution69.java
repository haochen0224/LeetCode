package COMPANY.ByteDance.BinarySearch;

/**
 * 69. x 的平方根
 * @Author Hao Chen
 * @Create 2022/7/29 20:06
 */
public class Solution69 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int ans = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if((long)mid*mid <= x){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
