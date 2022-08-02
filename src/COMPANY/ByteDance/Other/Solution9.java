package COMPANY.ByteDance.Other;

/**
 *  9. 回文数
 * @Author Hao Chen
 * @Create 2022/8/1 16:49
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int div = 1;
        while((x/div) >= 10){
            div *= 10;
        }
        while(x > 0){
            int left = x/div;
            int right = x%10;
            if(left != right){
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    //     Deque<Character> deque = new LinkedList<>();
    //     String digits = String.valueOf(x);
    //     char[] charArray = digits.toCharArray();
    //     for(char ch : charArray){
    //         deque.offerFirst(ch);
    //     }
    //     while(!deque.isEmpty()){
    //         if(deque.peekLast() != deque.peekFirst()){
    //             return false;
    //         }else{
    //             deque.pollLast();
    //             deque.pollFirst();
    //         }
    //     }
    //     return true;
    // }
}
