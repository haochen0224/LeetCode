package Matrix;

/**
 * 832. 翻转图像
 * @Author Hao Chen
 * @Create 2022/7/28 18:24
 */
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        for(int[] row : image){
            reverse(row,0,n-1);
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        return image;
    }
    private void reverse(int[] nums,int left, int right){
        while(left < right){
            swap(nums,left,right);
            ++left;
            --right;
        }
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**
     * 更简洁的实现
     */
//    public int[][] flipAndInvertImage(int[][] image) {
//        int m = image.length;
//        int n = image[0].length;
//        int[][] res = new int[m][n];
//        int index = 0;
//        for(int i = 0; i < m; ++i){
//            for(int j = n-1; j >= 0; --j){
//                res[i][index] = image[i][j] == 0 ? 1 : 0;
//                ++index;
//            }
//            index = 0;
//        }
//        return res;
//    }
}
