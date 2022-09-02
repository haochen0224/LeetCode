package DoublePointer;

/**
 * 468. 验证IP地址
 * @Author Hao Chen
 * @Create 2022/9/1 16:26
 */
public class Solution468 {
    public String validIPAddress(String queryIP) {
        if(queryIP.indexOf(".") >= 0 && checkIPv4(queryIP)) return "IPv4";
        if(queryIP.indexOf(":") >= 0 && checkIPv6(queryIP)) return "IPv6";
        return "Neither";
    }
    private boolean checkIPv4(String ip){
        int n = ip.length();
        int count = 0;
        char[] cs = ip.toCharArray();
        int i = 0;
        while(i < n && count <= 3){
            int j = i;
            int num = 0;
            while(j < n && cs[j] >= '0' && cs[j] <= '9' && num <= 255){
                num = num*10 + cs[j++]-'0';
            }
            if(j == i) return false;
            if((j-i > 1 && cs[i] == '0') || num > 255) return false;
            i = j+1;
            if(j == n) continue;
            if(cs[j] != '.') return false;
            ++count;
        }
        return count == 3 && cs[0] != '.' && cs[n-1] != '.';
    }
    private boolean checkIPv6(String ip){
        int n = ip.length();
        int count = 0;
        char[] cs = ip.toCharArray();
        int i = 0;
        while(i < n && count <= 7){
            int j = i;
            while(j < n && ((cs[j] >= '0' && cs[j] <= '9') || (cs[j] >= 'a' && cs[j] <= 'f') || (cs[j] >= 'A' && cs[j] <= 'F'))){
                ++j;
            }
            if(i == j || j-i > 4) return false;
            i = j+1;
            if(j == n) continue;
            if(cs[j] != ':') return false;
            ++count;
        }
        return count == 7 && cs[0] != ':' && cs[n-1] != ':';
    }
}
