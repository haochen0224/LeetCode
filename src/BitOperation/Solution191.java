package BitOperation;

/**
 * 191. 位1的个数
 * @Author Hao Chen
 * @Create 2022/10/2 12:54
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            n &= n-1;
            ++res;
        }
        return res;
    }
}
