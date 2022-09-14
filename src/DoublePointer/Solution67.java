package DoublePointer;

/**
 * 67. 二进制求和
 * @Author Hao Chen
 * @Create 2022/9/13 20:53
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        StringBuffer res = new StringBuffer();
        int p1 = A.length-1;
        int p2 = B.length-1;
        int carry = 0;
        while(p1 >= 0 || p2 >= 0){
            int n1 = p1 >= 0 ? A[p1]-'0' : 0;
            int n2 = p2 >= 0 ? B[p2]-'0' : 0;
            int sum = (n1 + n2 + carry)%2;
            carry = (n1 + n2 + carry)/2;
            res.insert(0,sum);
            if(p1 >= 0) --p1;
            if(p2 >= 0) --p2;
        }
        if(carry != 0){
            res.insert(0,carry);
        }
        return res.toString();
    }
}
