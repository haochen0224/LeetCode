package Heap;

/**
 * 215. 数组中的第K个最大元素
 * @Author Hao Chen
 * @Create 2022/7/20 0:14
 */
public class Solution215 {
    /**
     * 先从[0,k-1]构建一个大小为k的小根堆，然后从k位置开始遍历，将大于堆顶的元素交换至堆顶，然后进行heapify
     * 这样遍历完数组之后得到的就是前k个大的元素组成的小根堆，因此返回堆顶元素即为答案
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //从最后一个元素k-1的父亲节点(k-2)/2开始，向前进行heapify，构建大小为k的小根堆
        for(int i = (k-2)/2; i >= 0; --i){
            heapify(nums,i,k);
        }
        //k位置开始遍历，将大于堆顶的元素交换至堆顶，然后进行heapify
        for(int i = k; i < nums.length; ++i){
            if(nums[0] >= nums[i]){
                continue;
            }else{
                swap(nums,0,i);
                heapify(nums,0,k);
            }
        }
        //得到前k个大的元素组成的小根堆，因此返回堆顶元素即为答案
        return nums[0];
    }
    private void heapify(int[] nums,int i, int size){
        int left = 2*i + 1;
        while(left < size){
            int small = left+1 < size && nums[left] > nums[left+1] ? left+1 : left;
            if(nums[i] <= nums[small]){ //如果根节点比左右孩子都小，则堆调整完成
                break;
            }
            swap(nums,i,small);
            i = small;
            left = 2*i + 1;
        }
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * 更快的实现：快排思想。每次partition可以确定一个元素的最终位置，当partition的结果是nums.length-k的时候，就找到了目标值
 */

//class Solution215 {
//    Random random = new Random();
//    public int findKthLargest(int[] nums, int k) {
//        return quickSelection(nums,0,nums.length-1,nums.length-k);
//    }
//    private int quickSelection(int[] nums,int L, int R, int index){
//        int p = randomPartition(nums,L,R);
//        if(p == index){
//            return nums[p];
//        }
//        return p < index ? quickSelection(nums,p+1,R,index) : quickSelection(nums,L,p-1,index);
//    }
//    private int randomPartition(int[] nums,int L,int R){
//        int rand = random.nextInt(R-L+1)+L;
//        swap(nums,rand,R);
//
//        int pivot = nums[R];
//        int i = L-1;
//        for(int j = L; j < R; ++j){
//            if(nums[j] <= pivot){
//                swap(nums,++i,j);
//            }
//        }
//        swap(nums,i+1,R);
//        return i+1;
//    }
//    private void swap(int[] nums,int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//}

