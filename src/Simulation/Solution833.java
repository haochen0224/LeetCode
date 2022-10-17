package Simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 833. 字符串中的查找与替换
 * @Author Hao Chen
 * @Create 2022/10/16 19:08
 */
public class Solution833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[] change = new boolean[n]; //标记以该位置开始的某段字串需不需要被替换，如果需要被替换，则替换成target中相应的字符串
        Map<Integer,String> srcMap = new HashMap<>();
        Map<Integer,String> tarMap = new HashMap<>();
        for(int i = 0; i < indices.length; ++i){
            srcMap.put(indices[i],sources[i]);
            tarMap.put(indices[i],targets[i]);
        }
        for(int i = 0; i < indices.length; ++i){
            if(check(i,indices[i],cs,sources)){
                change[indices[i]] = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; ++i){
            if(!change[i]){ //不需要被替换，直接append
                res.append(cs[i]);
            }else{//需要被替换
                res.append(tarMap.get(i));//替换为相应的target中的字符串
                i += srcMap.get(i).length()-1;//跳到下一个待检测位置-1（减一是因为for循环开始时要+1，提前减一才能在下一个循环到达待检测位置）
            }
        }
        return res.toString();
    }
    private boolean check(int srcIndex,int indice,char[] cs,String[] sources){
        int len = sources[srcIndex].length();
        StringBuilder temp = new StringBuilder();
        for(int i = indice; i < Math.min(cs.length,indice+len); ++i){
            temp.append(cs[i]);
        }
        return temp.toString().equals(sources[srcIndex]);
    }
}
