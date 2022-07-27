package Other;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * @Author Hao Chen
 * @Create 2022/7/26 17:37
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
