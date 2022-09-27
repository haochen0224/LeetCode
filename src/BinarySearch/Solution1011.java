package BinarySearch;

/**
 * @Author Hao Chen
 * @Create 2022/9/26 18:27
 */
public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        if(weights.length == 0 || weights == null){
            return 0;
        }
        int n = weights.length;
        int L = 0, R = 0;
        for(int i = 0; i < n; ++i){
            L = Math.max(L,weights[i]); //二分查找左边界为weights[i]的最大值
            R += weights[i];            //右边界为weights的总和
        }
        while(L < R){
            int mid = L + ((R-L)>>1); //每次检验以mid为运载重量时，是否能在days天内完成任务
            if(canDeliver(weights,mid,days)){ //可以完成任务，则缩小右边界，缩小运载重量
                R = mid;
            }else{
                L = mid+1; //不能以mid为运载重量并在days天内完成任务，则扩大左边界，增加运载重量
            }
        }
        return L;
    }
    private boolean canDeliver(int[] weights,int mid,int days){
        int res = 1; //以mid为运载重量时，需要完成任务的天数
        int curWeight = 0; //当天装载的货物总重量
        int i = 0;
        int n = weights.length;
        while(i < n){
            curWeight += weights[i];
            if(i+1 < n && curWeight + weights[i+1] > mid){ //若加上下一个的货物重量，总重量就超过运载能力mid了，那么下一个货物需要等到下一天装载
                ++res;
                curWeight = 0;
            }
            ++i;
        }
        return res <= days;
    }
}
