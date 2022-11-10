package BinarySearch;

/**
 * 633. 平方数之和
 * @Author Hao Chen
 * @Create 2022/11/9 22:44
 */
public class Solution633 {
//    public boolean judgeSquareSum(int c) {
//        if(c < 0){
//            return false;
//        }
//        long left = 0, right = (int)Math.sqrt(c);
//        while(left <= right){
//            long sum = left*left + right*right;
//            if(sum == c){
//                return true;
//            }else if(sum > c){
//                --right;
//            }else{
//                ++left;
//            }
//        }
//        return false;
//    }
     public boolean judgeSquareSum(int c) {
         if(c < 0){
             return false;
         }
         for(int i = 0; i <= c; ++i){
             int target = c - i*i;
             if(target < 0){
                 break;
             }
             if(binarySearch(c,target)){
                 return true;
             }
         }
         return false;
     }
     private boolean binarySearch(int c,int target){
         int left = 0, right = c;
         while(left <= right){
             int mid = left + ((right-left)>>1);
             if((long)mid*mid == target){
                 return true;
             }else if((long)mid*mid > target){
                 right = mid - 1;
             }else{
                 left = mid + 1;
             }
         }
         return false;
     }
}
