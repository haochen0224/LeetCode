package Simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 582. 杀掉进程
 * @Author Hao Chen
 * @Create 2022/10/28 22:46
 */
public class Solution582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(pid == null || ppid == null){
            return new ArrayList<>();
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); ++i){
            if(ppid.get(i) != 0){
                List<Integer> list = map.getOrDefault(ppid.get(i),new ArrayList<>());
                list.add(pid.get(i));
                map.put(ppid.get(i),list);
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        dfs(map,kill,res);
        return res;
    }
    private void dfs(Map<Integer,List<Integer>> map,int kill,List<Integer> res){
        if(map.containsKey(kill)){
            for(int id : map.get(kill)){
                res.add(id);
                dfs(map,id,res);
            }
        }
    }
}
