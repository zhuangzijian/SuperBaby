package LeetCode;

import java.util.Arrays;

public class ZhongWeishu {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //int length=nums1.length+nums2.length;
        //存放结果
        double rsult;
        /*List<Integer> num=new ArrayList();
        List aa=Arrays.asList(nums1);
        List bb=Arrays.asList(nums2);
         num.addAll(aa);
         num.addAll(bb);*/
        //合并数组
        int[] num=new int[nums1.length+nums2.length];
        int s=0;
        for (int i = 0; i <nums1.length ; i++) {
            num[s++]=nums1[i];
        }
        for (int i = 0; i <nums2.length ; i++) {
            num[s++]=nums2[i];
        }
        //合并后的数组排序
         Arrays.sort(num);
        //判断是技术个偶数个  并算出所有的中位数
         if(num.length%2==0){
             rsult=(num[num.length/2-1]+num[num.length/2])*1.0/2;
         }else{
             rsult=num[(num.length-1)/2];
         }

    return rsult;
    }

    public static void main(String[] args) {
        ZhongWeishu a=new ZhongWeishu();
        int[] b={1,3};
        int[] c={2,4};
        System.out.println( a.findMedianSortedArrays(b,c));
    }
}
