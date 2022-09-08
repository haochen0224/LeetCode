package Greedy;

/**
 * 670. 最大交换
 * @Author Hao Chen
 * @Create 2022/9/8 0:43
 */
public class Solution670 {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] numChar = str.toCharArray();
        int[] last = new int[10];
        for(int i = 0; i < numChar.length; ++i){
            last[numChar[i]-'0'] = i;
        }
        for(int i = 0; i < numChar.length-1; ++i){
            for(int digit = 9; digit > numChar[i]-'0'; --digit){
                if(last[digit] > i){
                    swap(numChar,i,last[digit]);
                    return Integer.valueOf(new String(numChar));
                }
            }
        }
        return num;
    }
    private void swap(char[] numChar,int i,int j){
        char temp = numChar[j];
        numChar[j] = numChar[i];
        numChar[i] = temp;
    }
}
