package DoublePointer;

/**
 * 560. 和为 K 的子数组
 * @Author Hao Chen
 * @Create 2022/7/27 22:02
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int res = 0;
        while(left < nums.length){
            int sum = nums[left];
            if(sum == k){
                ++res;
            }
            int right = left + 1;
            while(right < nums.length){
                sum += nums[right];
                if(sum == k){
                    ++res;
                }
                ++right;
            }
            ++left;
        }
        return res;
    }
    /**
     * 更快的实现：前缀和
     */
//        Map<Integer,Integer> map = new HashMap<>();
//        int pre = 0;
//        int count = 0;
//        map.put(0,1);
//        for(int i = 0; i < nums.length; ++i){
//            pre += nums[i];
//            if(map.containsKey(pre-k)){
//                count += map.get(pre-k);
//            }
//            map.put(pre,map.getOrDefault(pre,0)+1);
//        }
//        return count;


}
