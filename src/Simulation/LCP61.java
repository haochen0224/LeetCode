package Simulation;

/**
 * LCP 61. 气温变化趋势
 * @Author Hao Chen
 * @Create 2022/9/24 11:34
 */
public class LCP61 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int[] trendA = new int[n-1];
        int[] trendB = new int[n-1];
        for(int i = 1; i < n; ++i){
            trendA[i-1] = Integer.compare(temperatureA[i], temperatureA[i - 1]);
            trendB[i-1] = Integer.compare(temperatureB[i], temperatureB[i - 1]);
        }
        int cnt = 0;
        int res = 0;
        for(int i = 0; i < n-1; ++i){
            if(trendA[i] == trendB[i]){
                ++cnt;
            }else{
                res = Math.max(res,cnt);
                cnt = 0;
            }
        }
        return Math.max(res,cnt);
    }
}
