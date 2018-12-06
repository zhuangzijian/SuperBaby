package LeetCode;

public class DelectVal {
    public int removeElement(int[] nums, int val) {
        if(nums.length<0)return 0;
        if (nums.length==1&&nums[0]==val)return 0;
        if (nums.length==1&&nums[0]!=val)return 1;
        int result=nums.length;
        int left=0;
        int right=nums.length-1;
        while(right>=left){
            if(nums[left]==val){
                for (int i = left; i <nums.length-1 ; i++) {
                    nums[i]=nums[i+1];
                }
                nums[nums.length-1]=Integer.MIN_VALUE;
                result--;
            }else {
                left++;
            }
            if(nums[right]==val){
                for (int i = right; i <nums.length-1 ; i++) {
                    nums[i]=nums[i+1];
                }
                nums[nums.length-1]=Integer.MIN_VALUE;
                result--;
            }else {
                right--;
            }


        }
        return result;
    }
/*
public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != val) {
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
}
 */
    public static void main(String[] args) {
        DelectVal a=new DelectVal();
        int [] re={3,3};

        a.removeElement(re,3);
    }
}
