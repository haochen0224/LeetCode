package Simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 * @Author Hao Chen
 * @Create 2022/10/4 17:41
 */
public class Solution811 {
    private Map<String,Integer> map; //记录每个域名的访问次数
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null){
            return new ArrayList<>();
        }
        map = new HashMap<>();
        for(String domain : cpdomains){
            String[] s = domain.split(" ");
            int req = Integer.parseInt(s[0]); //获取当前域名的访问次数
            dfs(req,s[1],0); //对当前域名的各级域名进行dfs，给每一级域名的访问次数都加上req
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){ //遍历map,将结果存到list中
            String s = entry.getKey();
            int req = entry.getValue();
            StringBuilder cur = new StringBuilder();
            cur.append(req).append(" ").append(s);
            res.add(cur.toString());
        }
        return res;
    }
    private void dfs(int req,String s,int index){
        if(index == s.length()){
            return;
        }
        String sub = s.substring(index); //截取当前域名
        map.put(sub,map.getOrDefault(sub,0)+req); //当前域名的访问次数加req
        while(s.charAt(index) != '.'){ //找到下一级域名
            ++index;
            if(index == s.length()){ //到达域名末尾，返回
                return;
            }
        }
        ++index;
        dfs(req,s,index); //在下一级域名上进行dfs
    }
}
