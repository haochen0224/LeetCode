package Simulation;

import java.util.HashMap;
import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 * @Author Hao Chen
 * @Create 2022/10/28 13:55
 */
public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if(items == null){
            return 0;
        }
        int index = new HashMap<String,Integer>(){{
            put("type",0);
            put("color",1);
            put("name",2);
        }}.get(ruleKey);
        int cnt = 0;
        for(List<String> item : items){
            if(item.get(index).equals(ruleValue)){
                ++cnt;
            }
        }
        return cnt;
    }
}
