package BinarySearch;

/**
 * 1855. 下标对中的最大距离
 * @Author Hao Chen
 * @Create 2022/11/10 13:45
 */
public class Solution1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return 0;
        }
        int res  = 0;
        for(int i = 0; i < nums1.length; ++i){
            int j = binarySearch(nums2,nums1[i],i);
            if(j != -1){
                res = Math.max(res,j-i);
            }
        }
        return res;
    }
    private int binarySearch(int[] nums2,int target,int left){
        int right = nums2.length-1;
        int res = -1;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(nums2[mid] >= target){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}
