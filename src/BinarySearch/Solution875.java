package BinarySearch;

/**
 * 875. 爱吃香蕉的珂珂
 * @Author Hao Chen
 * @Create 2022/9/22 18:08
 */
public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 0 || h == 0){
            return -1;
        }
        int max = 0;
        for(int i = 0; i < piles.length; ++i){
            max = Math.max(max,piles[i]);
        }
        int L = 1, R = max;
        while(L < R){
            int mid = L + ((R-L)>>1);
            if(canFinish(piles,mid,h)){
                R = mid;
            }else{
                L = mid+1;
            }
        }
        return L;
    }
    private boolean canFinish(int[] piles,int k,int h){
        int curTime = 0;
        for(int i = 0; i < piles.length; ++i){
            if(piles[i] <= k){
                ++curTime;
            }else{
                curTime += piles[i]%k == 0 ? piles[i]/k : piles[i]/k+1;
            }
        }
        return curTime <= h;
    }
}
