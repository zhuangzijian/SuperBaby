package LeetCode;

import java.util.Arrays;

/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //记录数组是否有变化
        int resultjuge=0;
        for (int i = nums.length-1; i >=1 ; i--) {
            for (int j = i-1; j >=0 ; j--) {

                if (nums[i]>nums[j]){
                    int sm =nums[i];
                    for (int k = i; k >j ; k--) {
                        nums[k]=nums[k-1];
                    }
                   nums[j]=sm;
                    resultjuge=1;
                    break;
                }
            }
            if (resultjuge>0)break;

        }
        if (resultjuge==0){
            Arrays.sort(nums);
        }
    }
}
