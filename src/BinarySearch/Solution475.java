package BinarySearch;

import java.util.Arrays;

/**
 * 475. 供暖器
 * @Author Hao Chen
 * @Create 2022/9/19 21:10
 */
public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int L = 0, R = (int)1e9;
        while(L < R){
            int mid = L + ((R-L)>>1);
            if(check(houses,heaters,mid)){
                R = mid;
            }else{
                L = mid+1;
            }
        }
        return R;
    }
    private boolean check(int[] houses,int[] heaters,int x){
        int n = houses.length, m = heaters.length;
        for(int i = 0, j = 0; i < n; ++i){
            while(j < m && houses[i] > heaters[j]+x){
                ++j;
            }
            if(j < m && heaters[j]-x <= houses[i] && houses[i] <= heaters[j]+x) continue;
            return false;
        }
        return true;
    }
}
