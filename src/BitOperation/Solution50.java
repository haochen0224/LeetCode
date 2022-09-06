package BitOperation;

/**
 * 50. Pow(x, n)
 * @Author Hao Chen
 * @Create 2022/9/5 16:58
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if(x == 0.0){
            return 0.0;
        }
        long N = n;
        if(n < 0){
            N = -N;
            x = 1/x;
        }
        double res = 1.0;
        while(N > 0){
            if((N&1) == 1){
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return res;
    }
}
