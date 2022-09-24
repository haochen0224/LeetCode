package BinarySearch;

/**
 * 410. 分割数组的最大值
 * @Author Hao Chen
 * @Create 2022/9/23 17:29
 */
public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int L = 0, R = 0;
        for(int i = 0; i < n; ++i){
            L = Math.max(L,nums[i]);
            R += nums[i];
        }
        while(L < R){
            int mid = L + ((R-L)>>1);
            if(check(nums,mid,m)){
                R = mid;
            }else{
                L = mid+1;
            }
        }
        return L;
    }
    private boolean check(int[] nums,int x,int m){
        int sum = 0;
        int cnt = 1;
        for(int i = 0; i < nums.length; ++i){
            if(sum+nums[i] > x){
                ++cnt;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
}
