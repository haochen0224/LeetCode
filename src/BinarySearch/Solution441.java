package BinarySearch;

/**
 * 441. 排列硬币
 * @Author Hao Chen
 * @Create 2022/11/5 18:36
 */
public class Solution441 {
    public int arrangeCoins(int n) {
        if(n < 1){
            return 0;
        }
        int left = 0, right = n;
        int res = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(check(n,mid)){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
    private boolean check(int n,int k){
        return (long)k*(1+k) <= (long) 2*n;
    }
}
