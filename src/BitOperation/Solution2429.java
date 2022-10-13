package BitOperation;

/**
 * 2429. 最小 XOR
 * @Author Hao Chen
 * @Create 2022/10/12 22:10
 */
public class Solution2429 {
    public int minimizeXor(int num1, int num2) {
        int m = count(num1);
        int n = count(num2);
        int res = num1;
        if(m > n){
            while(m != n){
                res &= res-1; //把最后一个1变为0
                --m;
            }
        }else if(m < n){
            while(m != n){
                res |= res+1; //把最后一个0变为1
                ++m;
            }
        }
        return res;
    }

    private int count(int num){
        int cnt = 0;
        while(num > 0){
            num &= num-1;
            ++cnt;
        }
        return cnt;
    }
}
