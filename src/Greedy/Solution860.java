package Greedy;

/**
 * 860. 柠檬水找零
 * @Author Hao Chen
 * @Create 2022/9/20 17:08
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0){
            return false;
        }
        int five = 0;
        int ten = 0;
        for(int i = 0; i < bills.length; ++i){
            if(bills[i] == 5){
                ++five;
            }else if(bills[i] == 10){
                if(five < 1){
                    return false;
                }else{
                    --five;
                    ++ten;
                }
            }else{
                if(ten > 0 && five > 0){
                    --ten;
                    --five;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
