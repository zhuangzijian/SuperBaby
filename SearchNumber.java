package LeetCode;
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
 */
public class SearchNumber {
    public int search(int[] nums, int target) {
        for (int j = 0; j <nums.length ; j++) {
            if (target==nums[j])  return j;

        }
        return -1;
    }

    public static void main(String[] args) {
        SearchNumber a=new SearchNumber();
        int[] b={1};
        System.out.println(a.search(b,1));
    }
}