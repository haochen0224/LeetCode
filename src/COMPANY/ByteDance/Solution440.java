package COMPANY.ByteDance;

/**
 * 440. 字典序的第K小数字
 * @Author Hao Chen
 * @Create 2022/7/24 20:36
 */
public class Solution440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        --k;
        while(k > 0){
            int count = getCount(curr,n);
            if(count <= k){
                k -= count;
                ++curr;
            }else{
                curr = curr*10;
                --k;
            }
        }
        return curr;
    }
    private int getCount(int curr,long n){
        int count = 0;
        long first = curr;
        long last = curr;
        while(first <= n){
            count += Math.min(last,n) - first + 1;
            first = first*10;
            last = last*10 + 9;
        }
        return count;
    }
}
