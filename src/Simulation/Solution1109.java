package Simulation;

/**
 * 1109. 航班预订统计
 * @Author Hao Chen
 * @Create 2022/9/20 16:38
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if(bookings.length == 0 || bookings[0].length == 0){
            return new int[0];
        }
        int[] res = new int[n];
        for(int i = 0; i < bookings.length; ++i){
            for(int j = bookings[i][0]; j <= bookings[i][1]; ++j){
                res[j-1] += bookings[i][2];
            }
        }
        return res;
    }
}
