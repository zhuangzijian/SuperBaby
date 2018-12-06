package LeetCode;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
       /* if (nums.length<=0)return 1;
        if (nums.length==1){
        if (nums[0]>0){
            if (nums[0]>1)return 1;else return nums[0]+1;
        }else return 1;
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-1 ; i++) {
            if (nums[i]>0){
               if (nums[i+1]-1==nums[i]){
                   if (nums[i]>1)return 1;else  continue;
               }else {
                   return nums[i]+1;
               }
            }
        }
        return nums[nums.length-1]+1;*/
       //处理特殊情况的时候 数组为空和数组为一的时候
        if (nums.length <= 0) return 1;
        if (nums.length == 1) {
            if (nums[0] > 0) {
                if (nums[0] > 1) return 1;
                else return nums[0] + 1;
            } else return 1;
        }
        Arrays.sort(nums);
        //为了记住最后一个第一个非负数的整数 如果有负数的情况下
        int m = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < 0) {
                m = i+1;
            }
            //如果有负数的情况下的第一个数大于1的话直接返回1 同时也可以判断0的时候是否大于1
            //总结来说就是看最前面的那一个是否大于1
            if (nums[m]>1)return 1;
            //看当前这个数+1和下一个数的关系
            if (nums[i] + 1 >= nums[i + 1]) {
                continue;
            } else {
                if (nums[i] + 1>0) {
                    return nums[i] + 1;
                }else continue;
            }

        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive a = new FirstMissingPositive();
        int[] b = {3,4,-1,1
};
        System.out.println(a.firstMissingPositive(b));
    }
}
