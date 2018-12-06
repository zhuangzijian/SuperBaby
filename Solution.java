package LeetCode;

public class Solution {
    public int myAtoi(String str) {
        /*
        8. 字符串转整数 (atoi)
        本人的大致思想就是首先把一个字符串 按长度for循环来进行切割 然后用asc码进行对比进行判断 输出
         */
         int result=0;
        //创建一个循环然后进行切割
        int flag = 0;
        for (int i = 0; i < str.length() && flag == 0; i++) {
            flag = 1;
            //截出的字符串并转化成int型
            int strnumber = str.charAt(i);
            switch (strnumber) {
                //第一位为空格
                case 32:
                    flag = 0;
                    break;
                //除了空格以外第一位为正号
                case 43: {
                    result= resultnumber(i+1,str);
                }
                break;
                //除了空格以外第一位为负号
                case 45: {
                    result=resultnumber(i+1,str);
                }
                break;
                //直接为字母或者为数字没有符号
                default:{
                    result= resultnumber(i,str);
                }break;
            }

        }
        return result;
    }
    public  int resultnumber(int i,String str){
        //创建一个结果集默认为0
         int result=0;
        int alg=0;
        int panduan=0;
        int weishu=0;
        if (i>0){
            if (str.charAt(i-1)==45){
                panduan=1;
            }
        }

        for (int j = i; j <str.length()&&alg==0 ; j++) {
           int strnumber=str.charAt(j);
           if (strnumber==48&&result==0)continue;
            if(strnumber>=48&&strnumber<=57){
                weishu++;
                if(panduan==1){
                    if(weishu>=10){
                        if (weishu==10){
                            if((strnumber-48)<=7){
                                result=result*10-(strnumber-48);
                            }else  result = Integer.MIN_VALUE;
                        }else {
                            result = Integer.MIN_VALUE;
                        }
                    }else {
                        result=result*10-(strnumber-48);
                    }
                }else {
                    if(weishu>=10){
                        if (weishu==10){
                            if((strnumber-48)<7){
                                result=result*10+(strnumber-48);
                            }else  result = Integer.MAX_VALUE;
                        }else {
                            result = Integer.MAX_VALUE;
                        }
                    }else{
                        result=result*10+(strnumber-48);
                    }
                }

            }else {
                alg=1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution a=new Solution();
        System.out.println(a.myAtoi("2147483646"));
    }
}
