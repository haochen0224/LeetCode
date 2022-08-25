package COMPANY.ByteDance.Other;

/**
 * 149. 直线上最多的点数
 * @Author Hao Chen
 * @Create 2022/8/24 20:17
 */
public class Solution149 {
    public int maxPoints(int[][] points) {
        if(points.length <= 2){
            return points.length;
        }
        int n = points.length;
        int res = 0;
        for(int i = 0; i < n-2; ++i){
            for(int j = i+1; j < n-1; ++j){
                int count = 2;
                int x1 = points[i][0]-points[j][0];
                int y1 = points[i][1]-points[j][1];
                for(int k = j+1; k < n; ++k){
                    int x2 = points[i][0]-points[k][0];
                    int y2 = points[i][1]-points[k][1];
                    if(x1*y2 == x2*y1){
                        ++count;
                    }
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}
