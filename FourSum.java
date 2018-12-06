package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4) return new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        int i=0;
        int j=nums.length-1;
        while(j-i>2){
            //作为比较对象
            int juge=0;
            int k=i+1;
            int l=j-1;
            while(k<l){
                juge=nums[i]+nums[j]+nums[k]+nums[l];
                if(juge==target){
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[k]);
                    result.add(nums[j]);
                    result.add(nums[l]);
                    set.add(result);
                    while(k< l && nums[k] == nums[k + 1]){
                        k++;
                    }
                    while(k<l&&nums[l]==nums[l+1]){
                        l--;
                    }
                    k++;
                    l--;
                }else if(juge<target){
                    k++;
                }else{
                    l--;
                }
                //相当于两个for循环每次j走到不合理的条件时则i会向前走一个而j恢复原位置在进行走一边
                //由于直接用值判断判断j与i会有遗漏所以进行修改
            } if (j-i>3){
                j--;
            }else {
                i++;
                j=nums.length-1;
            }
        }
        return new ArrayList<>(set);
    }
    public static void main(String []args){
        FourSum a=new FourSum();
        int [] s={-3,-1,0,2,4,5};
        System.out.println(a.fourSum(s, 2));

    }
}
