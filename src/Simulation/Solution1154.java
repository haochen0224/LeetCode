package Simulation;

/**
 * 1154. 一年中的第几天
 * @Author Hao Chen
 * @Create 2022/9/30 16:58
 */
public class Solution1154 {
    public int dayOfYear(String date) {
        if(date == null){
            return 0;
        }
        String[] str = date.split("-");
        int year = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1]);
        int day = Integer.parseInt(str[2]);
        int res = 0;
        for(int i = 1; i < month; ++i){
            if(i == 1 || i == 3 || i == 5|| i == 7 || i == 8 || i == 10 || i == 12){
                res += 31;
            }else if(i == 2 && (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)){
                res += 29;
            }else if(i == 2){
                res += 28;
            }else{
                res += 30;
            }
        }
        return res + day;
    }
}
