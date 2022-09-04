package Simulation;

/**
 * 171. Excel 表列序号
 * @Author Hao Chen
 * @Create 2022/9/3 20:33
 */
public class Solution171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(int i = 0; i < columnTitle.length(); ++i){
            int num = columnTitle.charAt(i)-'A'+1; //A代表的是1，因此当前字符代表的数字为columnTitle.charAt(i)-'A'+1
            res = res*26 + num; //26进制
        }
        return res;
    }
}
