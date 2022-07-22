package BinarySearch;

/**
 * 69. x 的平方根
 * @Author Hao Chen
 * @Create 2022/7/21 18:08
 */
public class Solution69 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((long)mid*mid <= x){
                ans = mid; //先把mid保存起来，因为下一个left可能就>right了
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
