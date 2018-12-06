package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class HS_KuoHaoPailie {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        String a="";
        p(a,n,n,result);
        return result;
    }
    public void p(String a,int left,int right,List<String> result) {
       /* if (left > right) {
            return;
        }
*/// 开始走此条件右边的扩号一定比左边的小
        if (left<=right&&left>0) {
            p(a +"(", left - 1, right,result);
        }
        //在字符串中的右括号小于左括号时才能进行右括号执行
        if (right>left&&right>0) {
            p(a+")" , left, right - 1,result);
        }
        if (left == 0 && right == 0) {
            result.add(a.toString());
            return;
        }
    }
      /*  if (right<left)return;
        if (left==0&&right==0){
            result.add(a);
            return ;
        }
        p(a+"(",left-1,right);
        p(a+")",left,right-1);

    }*/
      public static void main(String[] args) {
          HS_KuoHaoPailie a=new HS_KuoHaoPailie();
          System.out.println(a.generateParenthesis(3));
      }
}
