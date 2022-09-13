package Math;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * @Author Hao Chen
 * @Create 2022/9/12 20:35
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int pos = 0;
        for(int i = 2; i <= n; ++i){
            pos = (pos+m) % i;
        }
        return pos;
    }
}
