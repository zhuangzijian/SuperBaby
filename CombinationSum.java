package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> resluts = new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSumhuisu(candidates, target, resluts,0,result);
        return result;
    }

    public static void combinationSumhuisu(int[] candidates, int target, List<Integer> results,int start,List<List<Integer>> result) {

            //判断是否可以整减
            if(target<0){
                return ;
            }else  if (target == 0) {
                //指向一块新的不变的地址否则result会随着results改变而改变
                result.add(new ArrayList<Integer>(results));
                return;
            } else
                //start防止了i=2然后递归后i=1重复i=1 递归i=2时所以要固定其i
                for (int i = start; i < candidates.length; i++) {
                //判断target是否可以减掉candidates
                    results.add(candidates[i]);
                    combinationSumhuisu(candidates, target-candidates[i], results,i,result);
                    results.remove(results.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        int tage = 7;
        CombinationSum b = new CombinationSum();
        System.out.println(b.combinationSum(a, tage));
    }
}
