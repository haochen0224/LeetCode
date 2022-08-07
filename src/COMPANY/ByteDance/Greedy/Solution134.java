package COMPANY.ByteDance.Greedy;

/**
 * 134. 加油站
 * @Author Hao Chen
 * @Create 2022/8/6 20:05
 */
public class Solution134 {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int n = gas.length;
    //     for(int i = 0; i < n; ++i){
    //         int j = i;
    //         int remain = gas[i];
    //         while(remain >= cost[j]){
    //             remain = remain - cost[j] + gas[(j+1)%n];
    //             j = (j+1)%n;
    //             if(j == i){
    //                 return i;
    //             }
    //         }
    //         if(j < i){
    //             return -1;
    //         }else{
    //             i = j;
    //         }
    //     }
    //     return -1;
    // }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while(i < n){
            int sumOfGas = 0;
            int sumOfCost = 0;
            int count = 0;
            while(count < n){
                int j = (i+count) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if(sumOfGas < sumOfCost){
                    break;
                }
                count++;
            }
            if(count == n){
                return i;
            }else{
                i = i+count+1;
            }
        }
        return -1;
    }
}
