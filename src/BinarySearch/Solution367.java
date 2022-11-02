package BinarySearch;

/**
 * 367. 有效的完全平方数
 * @Author Hao Chen
 * @Create 2022/11/2 12:16
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        if(num <= 0){
            return false;
        }
        if(num == 1){
            return true;
        }
        int left = 0, right = num;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            long square = (long)mid * mid;
            if(square == num){
                return true;
            }else if(square > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
