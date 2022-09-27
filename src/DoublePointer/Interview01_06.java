package DoublePointer;

/**
 * 面试题 01.06. 字符串压缩
 * @Author Hao Chen
 * @Create 2022/9/26 20:01
 */
public class Interview01_06 {
    public String compressString(String S) {
        if(S == null || S.length() == 0){
            return "";
        }
        int i = 0, j = 0;
        StringBuffer res = new StringBuffer();
        int n = S.length();
        while(i < n){
            res.append(S.charAt(i));
            int cnt = 1;
            while(j+1 < n && S.charAt(j+1) == S.charAt(i)){
                ++cnt;
                ++j;
            }
            ++j;
            i = j;
            res.append(cnt);
        }
        if(res.length() >= S.length()){
            return S;
        }
        return res.toString();
    }
}
