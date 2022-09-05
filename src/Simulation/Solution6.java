package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * @Author Hao Chen
 * @Create 2022/9/4 23:32
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        for(int i = 0; i < numRows; ++i){
            rows.add(new StringBuffer());
        }
        int flag = -1;
        int i = 0;
        for(char ch : s.toCharArray()){
            rows.get(i).append(ch);
            if(i == 0 || i == numRows-1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuffer res = new StringBuffer();
        for(StringBuffer row : rows){
            res.append(row);
        }
        return res.toString();
    }
}
