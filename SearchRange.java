package LeetCode;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] res={-1,-1};
        while (left<=right){
            if (nums[left]==target){
                res[0]=left;
            }else left++;
            if (nums[right]==target){
                res[1]=right;
            }else right--;
            if (res[0]!=-1&&res[1]!=-1)break;
        }
        return res;
    }

    public static void main(String[] args) {
        SearchRange a=new SearchRange();
        int[] b={5,7,7,8,8,10};
        a.searchRange(b,8);
    }
}
