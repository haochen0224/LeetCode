package Other;

/**
 * 151. 反转字符串中的单词
 * @Author Hao Chen
 * @Create 2022/8/31 17:42
 */
public class Solution151 {
    public String reverseWords(String s) {
        if(s == null){
            return s;
        }
        StringBuffer res = new StringBuffer();
        String[] sArray = s.split(" ");
        for(int i = sArray.length-1; i >= 0; --i){
            if(!sArray[i].equals("")){
                res.append(sArray[i]);
                if(i > 0){
                    res.append(" ");
                }
            }
        }
        while(res.charAt(res.length()-1) == ' '){
            res.deleteCharAt(res.length()-1);
        }
        return res.toString();
    }
}
