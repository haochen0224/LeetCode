package BinarySearch;

/**
 * 278. 第一个错误的版本
 * @Author Hao Chen
 * @Create 2022/7/21 18:55
 */
public class Solution278 {
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while(left < right){
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }

        }
        return left;
    }
    private boolean isBadVersion(int n){return true;}
}
