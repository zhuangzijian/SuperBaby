package LeetCode;

//八皇后问题
/*
在一个8*8的棋盘上放置8个皇后，不允许任何两个皇后在棋盘的同一行、同一列和同一对角线上。
1）
对8 x 8的二维数组上的某点a[i][j](0<=i,j<=7)
如果a[s][q]满足|s-i|=|q-j|,a[s][q]在a[i][j]的对角线上。
如果s=i,则a[s][q]在a[i][j]的同一列上。

2）
每行有且仅有一个皇后：声明数组Queen[8] 存放皇后位置//Queen[n]数组的含义为将第n个皇后放在格子的（n,Queen[n])位置
public static int judge(int n)//判断(n，Queen[n])位置是否可以放皇后

3)
每一行只放一个皇后把每个点都试一遍使得试出最后的所有放皇后的位置
 */
public class HS_EightQueen {
    //定义皇后的个数
    static int queennum = 8;
    static int[] Queen = new int[queennum];
    //最后满足条件的次数
    static int count = 0;
    //写一个回溯的分别进行每一行进行放置皇后使得进行下一行的放置
    public static void NQueen(int n)//放置第n行皇后
    {
        //每一行的每一个位置进行测试放置皇后
        for (int i = 0; i < queennum; i++) {
            //皇后的位置进行赋值
            Queen[n]=i;
            //判断是否能放置皇后
            if(judge(n)){
                //如果是最后的一行并且满足条件的话则进行总次数的++操作
                if(n==queennum-1){
                    Show();
                    System.out.println();
                    count++;//方法加一
                }else {
                    //否则的话则进行下一行的皇后进行放置
                    NQueen(n+1);
                }

            }
        }

    }
    //写一个判断是否可放置的函数
    public static boolean judge(int n)//判断（n,Queen(n)）能否放置皇后* n为第几行
    {
        //循环要进行完因为要进行所有上满的列和所有上面的的对角线进行对比
        for (int j = 0; j <n ; j++) {
            //首先判断同列，再判断对角线 ，同行不用判断因为是逐行放的没行只放一个
            if(Queen[j]==Queen[n]||Math.abs(Queen[j]-Queen[n])==n-j){
                return false;
            }
        }
        return true;

    }
    public static void Show()
    {
        for(int i=0;i<queennum;i++)
        {
            System.out.print("("+i+","+Queen[i]+")");
        }
    }
    public static void main(String[] args){
        NQueen(0);            //初始放置第一行的皇后
        System.out.print("共有"+count+"种方式");
    }
}
