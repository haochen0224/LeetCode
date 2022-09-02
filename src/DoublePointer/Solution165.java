package DoublePointer;

/**
 * 165. 比较版本号
 * @Author Hao Chen
 * @Create 2022/9/1 15:51
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null){
            return 0;
        }
        int p1 = 0, p2 = 0;
        int m = version1.length();
        int n = version2.length();
        while(p1 < m || p2 < n){
            int num1 = 0;
            while(p1 < m && version1.charAt(p1) != '.'){
                num1 = num1*10 + version1.charAt(p1)-'0';
                ++p1;
            }
            ++p1;
            int num2 = 0;
            while(p2 < n && version2.charAt(p2) != '.'){
                num2 = num2*10 +version2.charAt(p2)-'0';
                ++p2;
            }
            ++p2;
            if(num1 != num2){
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }
}
