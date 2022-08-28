package Geometry;

/**
 * 223. 矩形面积
 * @Author Hao Chen
 * @Create 2022/8/27 18:22
 */
public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1) * (ay2-ay1);
        int area2 = (bx2-bx1) * (by2-by1);
        int overLapWidth = Math.min(ax2,bx2)-Math.max(ax1,bx1);
        int overLapHeight = Math.min(ay2,by2)-Math.max(ay1,by1);
        int overLapArea = Math.max(overLapWidth,0) * Math.max(overLapHeight,0);
        return area1+area2-overLapArea;
    }
}
