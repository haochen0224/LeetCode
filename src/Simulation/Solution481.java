package Simulation;

/**
 * 481. 神奇字符串
 * @Author Hao Chen
 * @Create 2022/10/30 13:23
 */
public class Solution481 {
    public int magicalString(int n) {
        if(n < 4){
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int i = 2, j = 3;
        int res = 1;
        while(j < n){
            int size = s[i] - '0';
            int num = 3 - (s[j-1] - '0');
            while(size > 0 && j < n){
                s[j] = (char)(num + '0');
                if(s[j] == '1'){
                    ++res;
                }
                --size;
                ++j;
            }
            ++i;
        }
        return res;
    }
}
