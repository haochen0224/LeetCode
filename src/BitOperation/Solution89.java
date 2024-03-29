package BitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * @Author Hao Chen
 * @Create 2022/8/28 19:11
 */
public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>(){{add(0);}};
        if(n < 0){
            return res;
        }
        int head = 1;
        for(int i = 0; i < n; ++i){
            for(int j = res.size()-1; j >= 0; --j){
                res.add(head+res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
