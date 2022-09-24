package Greedy;

/**
 * 12. 整数转罗马数字
 * @Author Hao Chen
 * @Create 2022/9/24 13:53
 */
public class Solution12 {
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < values.length; ++i){
            while(num >= values[i]){
                num -= values[i];
                res.append(symbols[i]);
            }
            if(num == 0){
                break;
            }
        }
        return res.toString();
    }
}
