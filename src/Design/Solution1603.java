package Design;

/**
 * @Author Hao Chen
 * @Create 2022/8/23 17:17
 */
public class Solution1603 {
}
class ParkingSystem {
    int big;
    int medium;
    int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == 3){
            if(small >= 1){
                --small;
                return true;
            }
        }else if(carType == 2){
            if(medium >= 1){
                --medium;
                return true;
            }
        }else if(carType == 1){
            if(big >= 1){
                --big;
                return true;
            }
        }
        return false;
    }
}
