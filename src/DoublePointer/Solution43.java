package DoublePointer;

/**
 * 43. 字符串相乘
 * @Author Hao Chen
 * @Create 2022/8/30 17:36
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "0";
        for(int i = num2.length()-1; i >= 0; --i){
            StringBuffer temp = new StringBuffer();
            int carry = 0;
            for(int j = 0; j < num2.length()-1-i; ++j){
                temp.append("0");
            }
            int n2 = num2.charAt(i)-'0';
            for(int j = num1.length()-1; j >= 0 || carry != 0; --j){
                int n1 = j < 0 ? 0 : num1.charAt(j)-'0';
                int product = (n1*n2+carry)%10;
                temp.append(product);
                carry = (n1*n2+carry)/10;
            }
            res = addToString(res,temp.reverse().toString());
        }
        return res;
    }
    private String addToString(String num1,String num2){
        StringBuffer res = new StringBuffer();
        int carry = 0;
        for(int i = num1.length()-1,j = num2.length()-1; i >= 0 || j >= 0 || carry != 0; --i,--j){
            int n1 = i < 0 ? 0 : num1.charAt(i)-'0';
            int n2 = j < 0 ? 0 : num2.charAt(j)-'0';
            int sum = (n1+n2+carry) % 10;
            res.append(sum);
            carry = (n1+n2+carry) / 10;
        }
        return res.reverse().toString();
    }
}
