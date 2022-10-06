package Simulation;

/**
 * 927. 三等分
 * @Author Hao Chen
 * @Create 2022/10/5 18:48
 */
public class Solution927 {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int a : arr){
            sum += a == 1 ? 1 : 0;
        }
        if(sum % 3 != 0){
            return new int[]{-1,-1};
        }
        if(sum == 0){
            return new int[]{0,2};
        }
        int partial = sum/3;
        int first = 0, second = 0, third = 0, cur = 0;
        for(int i = 0; i < n; ++i){
            if(arr[i] == 1){
                if(cur == 0){
                    first = i;
                }else if(cur == partial){
                    second = i;
                }else if(cur == partial * 2){
                    third = i;
                }
                ++cur;
            }
        }
        int len = n - third;
        if(first+len <= second && second+len <= third){
            int i = 0;
            while(third+i < n){
                if(arr[first+i] != arr[second+i] || arr[first+i] != arr[third+i]){
                    return new int[]{-1,-1};
                }
                ++i;
            }
            return new int[]{first+len-1,second+len};
        }
        return new int[]{-1,-1};
    }
}
