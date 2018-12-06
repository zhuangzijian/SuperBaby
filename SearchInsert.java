package LeetCode;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
本人思路：二分排序
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if (target>nums[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
            return left;
    }

    public static void main(String[] args) {
        SearchInsert a=new SearchInsert();
        int[] b={1,3,5,6};
        System.out.println(a.searchInsert(b,5));
    }
}
