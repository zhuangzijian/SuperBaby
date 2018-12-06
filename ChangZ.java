package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ChangZ {
    public String convert(String s, int numRows) {
        /*
        将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
        字母横过来呈现z走向
        P   A   H   N
        A P L S I I G
        Y   I   R
        大致思想：输入的给定行数 numrows 然后减去开头结尾就是numrows-2就是拐弯时一列一个的个数呈现一个二维数组
        最后按顺序来进行输出数组中的非空字母
         */
      /*  s="abcdefjhijklmnop";
        numRows=4;
        //首先创建二维数组棋盘
        int slength=s.length();
        //加载中间拐弯处的个数
        int centre=numRows-2;
        //拐弯加上前面的竖道是循环的所以做取余
        int surplus=slength%(centre+numRows);
        int a=slength/(centre+numRows);
        //计算已有的二维数组现在所需要的长度
        int rowslength= (centre+1)*a;
        //判断是否超过竖道
        if(surplus>numRows){
            //如果大于说明不能只加1还要加上拐弯部分
            rowslength+=1+surplus-numRows;
        }else {
            rowslength+=1;
        }
        //创建棋盘
        char[][] checkerboard=new char[numRows][rowslength];
        //拐弯加上前面的竖道是循环的所以做取余
        int surplu=slength%(centre+numRows);
        int b=slength/(centre+numRows);
        //计算已有的二维数组现在所需要的长度
        int rowlength= (centre+1)*b;
        //每个分割逐个分割
        int subnumber=0;
        //嵌套循环 第一层循环 把竖折看做一个循环 一共有多少个循环   第二个循环来进行分割字符串
        for (int i = 0; i <=b ; i++) {
            for (int j = 0; j <centre+numRows ; j++) {
                //加一个循环行数中的下一行
                int netrows=j+1-numRows;
                //判断是否为字符串长度结束
                if(subnumber>slength){
                    break;
                }
            //经过if判断把第一列放到棋盘中去
            if (j<numRows){
                checkerboard[i*(centre+1)-1][j]=s.charAt(subnumber);//数组下标越界
            }else {
                checkerboard[netrows][rowslength-1-netrows]=s.charAt(subnumber);
            }

            subnumber++;
            }
            if(subnumber>slength){
                break;
            }
        }
       *//* for (int k = 0; k <surplu ; k++) {
            checkerboard[numRows-(centre+1)-1+k][rowslength-1-netrows]=s.charAt(subnumber);
        }*//*
        for (int i = 0; i <numRows ; i++) {
            for (int j = 0; j <rowslength ; j++) {

                System.out.println(checkerboard[i][j]);
            }
        }
       */
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
    public static void main(String[] args) {
        ChangZ a=new ChangZ();
        a.convert("a",1);
    }
}

