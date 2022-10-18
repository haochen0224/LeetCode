package BitOperation;

/**
 * 779. 第K个语法符号
 * @Author Hao Chen
 * @Create 2022/10/17 15:05
 */
public class Solution779 {
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }
        if(k <= 1<<(n-2)){
            return kthGrammar(n-1,k);
        }
        return kthGrammar(n-1,k-(1<<(n-2))) ^ 1;
    }
}
