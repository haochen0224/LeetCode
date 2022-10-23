package DP;

import java.util.Arrays;

/**
 * 1235. 规划兼职工作
 * @Author Hao Chen
 * @Create 2022/10/21 20:42
 */
public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if(startTime == null || endTime == null || profit == null){
            return 0;
        }
        int n = startTime.length;
        int[][] job = new int[n][3];
        for(int i = 0; i < n; ++i){
            job[i] = new int[]{startTime[i],endTime[i],profit[i]};
        }
        Arrays.sort(job,(a, b) -> a[1] - b[1]);
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; ++i){
            int k = binarySearch(job,i-1,job[i-1][0]);
            dp[i] = Math.max(dp[i-1],dp[k]+job[i-1][2]);
        }
        return dp[n];
    }
    private int binarySearch(int[][] job,int right,int target){
        int left = 0;
        while(left < right){
            int mid = left + ((right-left)>>1);
            if(job[mid][1] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
