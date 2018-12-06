package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay a=new CountAndSay();
        System.out.println(a.countAndSay(3));
    }
    public String countAndSay(int n) {
        String result="1";
        for (int i = 1; i <n ; i++) {
           result=countAndSayRes(result);
        }
        return result;
    }
    public String countAndSayRes(String res){
        String result="";
        for (int i = 0; i <res.length() ; i++) {
            int cont=1;
            char ressub=res.charAt(i);
            while (i+1<res.length()&&res.charAt(i+1)==ressub){
                cont++;
                i=i+1;
            }
            result+=cont;
            result+=ressub;
        }
        return result;
    }
}
