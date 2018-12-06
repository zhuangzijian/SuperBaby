package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

    /*

     *首先用三个for循环是不行的因为三个for时间复杂对超过了，那么我的思路就是遍历数组时进行两个指针
     *进行遍历，利用hashset不可重复进行判断重复，我们队数组排序使得它可以让进入到set中的数组相同

     */

    /* public List<List<Integer>> threeSum(int[] nums) {
         int jugevalue=0;
         //存放最后的List
         List<List<Integer>> result=new ArrayList<>();
         for (int i = 0; i <nums.length-2 ; i++) {
             for (int j = i+1; j <nums.length-1 ; j++) {
                 for (int k = j+1; k <nums.length ; k++) {
                     int num=nums[i]+nums[j]+nums[k];
                     if (num==jugevalue){
                         List<Integer> trueList=new ArrayList<>();
                         int[] mm=new int[3];
                         mm[0]=nums[i];
                         mm[1]=nums[j];
                         mm[2]=nums[k];
                         Arrays.sort(mm);
                         trueList.add(mm[0]);
                         trueList.add(mm[1]);
                         trueList.add(mm[2]);
                         if (!result.contains(trueList))
                             result.add(trueList);
                     }
                         }


                 }
             }

     return result;
     }*/
    public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         *首先用三个for循环是不行的因为三个for时间复杂对超过了，那么我的思路就是遍历数组时进行两个指针
         *进行遍历，利用hashset不可重复进行判断重复，我们队数组排序使得它可以让进入到set中的数组相同
         */
        //对数组进行排序
        if (nums == null) {
            return null;
        }
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        //对数组nums进行排序
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            //数字k要从最大的数字（最后一个向前跑）
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    set.add(result);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k-1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }

            }

        }

        return new ArrayList<>(set);

    }


    public static void main(String[] args) {
        ThreeSum a=new ThreeSum();
        int[] c={-2,0,1,1,2};
        System.out.println(a.threeSum(c));
    }
}
