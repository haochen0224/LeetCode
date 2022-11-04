package BinarySearch;

/**
 * 744. 寻找比目标字母大的最小字母
 * @Author Hao Chen
 * @Create 2022/11/3 20:51
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length-1;;
        char res = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(letters[mid] > target){
                res = letters[mid];
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res == 0 ? letters[0] : res;
    }
}
