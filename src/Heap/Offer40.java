package Heap;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * @Author Hao Chen
 * @Create 2022/9/13 21:01
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0){
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int num : arr){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        for(int i = 0; i < res.length; ++i){
            res[i] = pq.poll();
        }
        return res;
    }
    //更快的实现：快排
//    Random rand = new Random();
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if(arr.length == 0 || k == 0){
//            return new int[0];
//        }
//        quickSelection(arr,0,arr.length-1,k-1);
//        int[] res = new int[k];
//        for(int i = 0; i < k; ++i){
//            res[i] = arr[i];
//        }
//        return res;
//    }
//    private void quickSelection(int[] arr,int L,int R,int index){
//        int p = randomPartition(arr,L,R);
//        if(p == index){
//            return;
//        }
//        if(p > index){
//            quickSelection(arr,L,p-1,index);
//        }else{
//            quickSelection(arr,p+1,R,index);
//        }
//    }
//    private int randomPartition(int[] arr,int L,int R){
//        int randIndex = rand.nextInt(R-L+1)+L;
//        swap(arr,randIndex,R);
//        int pivot = arr[R];
//        int i = L-1;
//        for(int j = L; j < R; ++j){
//            if(arr[j] <= pivot){
//                swap(arr,++i,j);
//            }
//        }
//        swap(arr,i+1,R);
//        return i+1;
//    }
//    private void swap(int[] arr,int i,int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}
