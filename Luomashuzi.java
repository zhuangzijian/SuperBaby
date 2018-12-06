package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
    整数转化为罗马数字
    思路一：是对输入的数进行取余数分别从高位向地位进行分解把数按位来进行分解；然后进行转化为罗马数字
 */
public class Luomashuzi {

    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        int[] b = new int[4];
        for (int i = 0; i < 4; i++) {

            if (num > 0) {
                b[i] = num % 10;
                num = num / 10;
            } else {
                break;
            }

        }
        for (int i = 3; i >= 0; i--) {
            if (b[i] > 0) {
                if (i > 0) {
                    result.append(judge(b[i] * (Math.pow(10,i))));
                } else {
                    result.append(judge(b[i]));
                }

            } else {
                continue;
            }
        }
        return result.toString();
    }
   /*    while (true){
           if(num<10){
               result.append(judge(num));
               return result.toString();
           }
           result.append(judge( num % a));
           num=num-num%a;
           a*=a;
       }


    }*/

   /* //用递归来进行分解数字
    public StringBuffer numResolve(int num) {
        if (num < 10) {
            return result.append(judge(num));
        } else {
            result.append(judge(num = num - num / 10));
            return numResolve(num);
        }
    }*/

    //用来判断分割后的数字所在的大致范围然后进行装换字符串
    public String judge(double num) {
        StringBuffer L = new StringBuffer();
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                L.append("M");
            }
        }
        if (num < 1000 && num >= 100) {
            if (num < 1000 && num > 500) {
                if (num == 900) {
                    L.append("CM");
                } else {
                    L.append("D");
                    for (int i = 0; i < (num - 500) / 100; i++) {
                        L.append("C");
                    }
                }
            }
            if (num <= 500 && num >= 100) {
                if (num == 500) {
                    L.append("D");
                }
                if (num == 400) {
                    L.append("CD");
                }
                if (num < 400) {
                    for (int i = 0; i < num / 100; i++) {
                        L.append("C");
                    }
                }
            }
        }
        if (num < 100 && num >= 10) {
            if (num < 100 && num > 50) {
                if (num == 90) {
                    L.append("XC");
                } else {
                    L.append("L");
                    for (int i = 0; i < (num - 50) / 10; i++) {
                        L.append("X");
                    }
                }
            }
            if (num <= 50 && num >= 10) {
                if (num == 50) L.append("L");
                if (num == 40) {
                    L.append("XL");
                }
                if (num < 40) {
                    for (int i = 0; i < num / 10; i++) {
                        L.append("X");
                    }
                }
            }
        }
        if (num < 10 && num > 0) {
            if (num < 10 && num > 5) {
                if (num == 9) {
                    L.append("IX");
                } else {
                    L.append("V");
                    for (int i = 0; i < (num - 5); i++) {
                        L.append("I");
                    }
                }
            }
            if (num <= 5 && num > 0) {
                if (num == 5) L.append("V");
                if (num == 4) {
                    L.append("IV");
                }
                if (num < 4) {
                    for (int i = 0; i < num; i++) {
                        L.append("I");
                    }
                }
            }
        }

        return L.toString();
    }

    public static void main(String[] args) {
        Luomashuzi a = new Luomashuzi();
        System.out.println(a.intToRoman(10));
    }
}
