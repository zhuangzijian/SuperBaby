package LeetCode;

public class Trap {
    /*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
示例:
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
     */
    public int trap(int[] height) {
        int sum=0;
        //为了判断雨水格是否可以有中间的雨水格
        int heightmodel=1;
        //分块求一开始先求高度唯一的雨水格子
        boolean flag=false;
        //遇到一个空则加temp 也就相当于加一个雨水格子
        int temp=0;
        //为了判断是否所有的数字都达不到此高度 要跳出循环
        boolean Flagel=false;
        while (true){
            flag=false;
            Flagel=false;
             temp=0;
            //循环向上进行分高度计算 把它想象成都是高度为一的进行计算
            for (int i = 0; i <height.length ; i++) {
                if (height[i]>=heightmodel){
                    flag=true;
                    Flagel=true;
                    //加上雨水的格子
                    sum+=temp;
                    //清空雨水的格子
                    temp=0;
                }else{
                    if (Flagel){
                        temp++;
                    }
                }
            }
            if (!flag){
                break;
            }
            //高度加一计算下一层的雨水一块
            heightmodel++;
        }
        return sum;
    }
}
