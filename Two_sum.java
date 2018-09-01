package LeetCode;

/*
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */

public class Two_sum {
    public int[] twoSum(int[] nums, int target) {
        int[] s = new int[2];
        for(int i=0;i<nums.length-1;i++){			//每个都遍历 互相加和 进行判断
            for(int k=i+1;k<nums.length;k++){
                int m=0;
                m=target-(nums[i]+nums[k]);
                if(m==0){
                    s[0]=i;
                    s[1]=k;

                }

            }
        }




        return s;
    }
}
