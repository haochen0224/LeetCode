package COMPANY.ByteDance.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * @Author Hao Chen
 * @Create 2022/7/22 21:56
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        List<StringBuffer> list=  new ArrayList<>();
        for(int i = 0; i < numRows; ++i){
            list.add(new StringBuffer());
        }
        int i = 0;
        int flag = -1;
        for(char ch : s.toCharArray()){
            list.get(i).append(ch);
            if(i == 0 || i == numRows-1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuffer res = new StringBuffer();
        for(StringBuffer row : list){
            res.append(row);
        }
        return res.toString();
    }
}
