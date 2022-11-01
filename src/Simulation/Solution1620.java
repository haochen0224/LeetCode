package Simulation;

/**
 * 1620. 网络信号最好的坐标
 * @Author Hao Chen
 * @Create 2022/11/1 18:13
 */
public class Solution1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        if(towers == null || towers.length == 0){
            return new int[0];
        }
        int maxX = 0, maxY = 0;
        for(int[] tower : towers){
            int curX = tower[0], curY = tower[1];
            maxX = Math.max(maxX,curX);
            maxY = Math.max(maxY,curY);
        }
        int[] res = new int[2];
        double maxStrength = 0;
        for(int i = 0; i <= maxX; ++i){
            for(int j = 0; j <= maxY; ++j){
                double curStrength = 0;
                for(int[] tower : towers){
                    int curX = tower[0], curY = tower[1];
                    double distance = getDistance(i,j,curX,curY);
                    if(distance <= radius){
                        curStrength += Math.floor(tower[2]/(1+distance));
                    }
                }
                if(curStrength > maxStrength){
                    maxStrength = curStrength;
                    res[0] = i;
                    res[1] = j;
                }else if(curStrength == maxStrength){
                    if(i < res[0]){
                        res[0] = i;
                        res[1] = j;
                    }else if(i == res[0] && j < res[1]){
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }
    private double getDistance(int x1,int y1,int x2,int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}
