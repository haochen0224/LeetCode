package DoublePointer;

/**
 * 38. 外观数列
 * @Author Hao Chen
 * @Create 2022/9/14 21:04
 */
public class Solution38 {
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2; i <= n; ++i){
            int start = 0;
            int pos = 0;
            StringBuffer sbuffer = new StringBuffer();
            while(start < str.length()){
                while(pos < str.length() && str.charAt(pos) == str.charAt(start)){
                    ++pos;
                }
                sbuffer.append(Integer.toString(pos-start)).append(str.charAt(start));
                start = pos;
            }
            str = sbuffer.toString();
        }
        return str;
    }
}
