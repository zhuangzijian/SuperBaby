package LeetCode;

import java.util.*;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        Arrays.sort(candidates);
        Set<List<Integer>> juge=new HashSet<>();
        combinationsum3(results,juge,result,-1,target,candidates);
        return results;
    }

    public void combinationsum3(List<List<Integer>> results, Set<List<Integer>> juge, List<Integer> result, int start, int target, int[] candidates) {
        if (target == 0) {
            if (!juge.contains(new ArrayList<Integer>(result))) {
                juge.add(new ArrayList<Integer>(result));
                results.add(new ArrayList<Integer>(result));
            }
            return;
        }
        if (target < 0) {
            return;
        } else {
            for (int i = start + 1; i < candidates.length; i++) {
                result.add(candidates[i]);
                combinationsum3(results,juge, result, i, target-candidates[i], candidates);
                result.remove(result.size() - 1);
            }
        }

    }
   /* public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        help(candidates,target,0,new ArrayList<Integer>(),result);
        return result;
    }
    public void help(int[] candidates, int target,int index,List<Integer> list,List<List<Integer>> result){
        if(target >0){
            for(int i = index; i< candidates.length&&target>=candidates[index];i++){
                list.add(candidates[i]);
                help(candidates,target-candidates[i],i+1,list,result);
                //已经退出来说明此数candidates[i]数不合适所以与它相同的数肯定也不合适
                while(i<= candidates.length-2 &&candidates[i]==candidates[i+1]){
                    i++;
                }
                list.remove(list.size()-1);
            }
        }else if(target == 0){
            result.add(new ArrayList<Integer>(list));
        }
    }*/
    public static void main(String[] args) {
        CombinationSum2 a=new CombinationSum2();
        int[]b={10,1,2,7,6,1,5 };
        System.out.println( a.combinationSum2(b,8));
    }
}
