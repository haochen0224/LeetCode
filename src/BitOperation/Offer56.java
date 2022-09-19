package BitOperation;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * @Author Hao Chen
 * @Create 2022/9/18 19:02
 */
public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, pivot = 1;
        for(int num : nums){
            n ^= num;
        }
        while((n&pivot) == 0){ //从右边开始找到x和y第一个不同的位，并以该位代表的值作为划分值，将nums划分为该位为1的数和该位为0的数
                                //那么x和y一定分别在这两个组中，将x和y分别与组内的其他数异或，可得x和y
            pivot <<= 1;
        }
        for(int num : nums){
            if((num&pivot) == 0){
                x ^= num;
            }else{
                y ^= num;
            }
        }
        return new int[]{x,y};
    }
}
