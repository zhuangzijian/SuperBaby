package LeetCode;

import java.util.Arrays;

public class ThreeSumJ {
    public int threeSumClosest(int[] nums, int target) {
        //为了使相差值比较获取最大值
        int min=Integer.MAX_VALUE ;
        int[] result=new int[3];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(Math.abs(nums[i]+nums[j]+nums[k]-target)<min){
                    min=Math.abs(nums[i]+nums[j]+nums[k]-target);
                    result[0]=nums[i];
                    result[1]=nums[j];
                    result[2]=nums[k];
                }else if(nums[i]+nums[j]+nums[k]-target<0){
                    j++;
                }else{
                    k--;
                }
            }
        }

        return result[0]+result[1]+result[2];
    }
}
