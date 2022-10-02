package Simulation;

/**
 * 1694. 重新格式化电话号码
 * @Author Hao Chen
 * @Create 2022/10/1 12:48
 */
public class Solution1694 {
    public String reformatNumber(String number) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < number.length(); ++i){
            if(Character.isDigit(number.charAt(i))){
                str.append(number.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        int n = str.length();
        int i = 0;
        while(n > 0){
            if(n > 4){
                res.append(str.substring(i,i+3) + "-");
                n -= 3;
                i += 3;
            }else{
                if(n == 4){
                    res.append(str.substring(i,i+2)+"-"+str.substring(i+2,i+4));
                }else{
                    res.append((str.substring(i,i+n)));
                }
                break;
            }
        }
        return res.toString();
    }
}
