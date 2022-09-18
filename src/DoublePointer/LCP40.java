package DoublePointer;

import java.util.Arrays;

/**
 * LCP 40. 心算挑战
 * @Author Hao Chen
 * @Create 2022/9/17 15:03
 */
public class LCP40 {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int index = cards.length-1;
        int sum = 0;
        while(cnt-- > 0){
            sum += cards[index--];
        }
        if(sum%2 == 0){
            return sum;
        }
        for(int i = index; i >= 0; --i){
            for(int j = index+1; j < cards.length; ++j){
                sum -= cards[j];
                sum += cards[i];
                if(sum%2 == 0){
                    return sum;
                }
                sum -= cards[i];
                sum += cards[j];
            }
        }
        return 0;
    }
}
