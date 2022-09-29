package DoublePointer;

/**
 * 2105. 给植物浇水 II
 * @Author Hao Chen
 * @Create 2022/9/28 21:42
 */
public class Solution2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int i = 0, j = n-1;
        int res = 0;
        int initialA = capacityA;
        int initialB = capacityB;
        while(i <= j){
            if(i == j){
                if(capacityA >= capacityB){
                    if(plants[i] > capacityA){
                        ++res;
                    }
                }else{
                    if(plants[j] > capacityB){
                        ++res;
                    }
                }
                break;
            }
            if(plants[i] <= capacityA){
                capacityA -= plants[i];
            }else{
                ++res;
                capacityA = initialA;
                capacityA -= plants[i];
            }
            ++i;
            if(plants[j] <= capacityB){
                capacityB -= plants[j];
            }else{
                ++res;
                capacityB = initialB;
                capacityB -= plants[j];
            }
            --j;
        }
        return res;
    }
}
