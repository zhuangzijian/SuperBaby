package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

//盛最多水的容器
public class WaterMaxArea {
    public int maxArea(int[] height) {
        //盛放最后的面积的最大值
        int maxarrea=0;
        //ArrayList<Integer> result=new ArrayList<Integer>();
        for (int i = 0; i <height.length-1 ; i++) {
            for (int j = i+1; j < height.length; j++) {
                //遍历从第一个到最后一个所有的面积
             //int heightReal = Math.min(height[i],height[j]);
            // int wide=Math.abs(j-i);
            // int area=Math.min(height[i],height[j])*(j-i);
                maxarrea=Math.max(maxarrea,Math.min(height[i],height[j])*(j-i));
            }

        }
        //Collections.sort(result);//针对一个ArrayList内部的数据排序
        //Arrays.sort(result);//Arrays是util包数组排序

    return maxarrea;
    }
}
