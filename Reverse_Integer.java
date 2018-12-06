package LeetCode;

import java.util.Stack;

public class Reverse_Integer {
    public long reverse(int x) {
        //放入栈中栈顶就是个位然后取出依次累加
        Stack stack = new Stack();
        if (x > 0) {
            //每次取余然后除以10后得到的数
            int a = x;
            //余数放在栈中的数
            long stacknumber = 0;
            while (a > 0) {
                stacknumber = a % 10;
                a = a / 10;
                stack.push(stacknumber);
            }
            //存放结果result
            long result = 0;
            //循环次数
            int j = 0;

            while (!stack.empty()) {
                //第几位；
                int wnumaber = 1;
                for (int i = 0; i < j; i++) {
                    wnumaber *= 10;
                }
                result += (long) stack.peek()*wnumaber;
                stack.pop();
                j++;
            }
            return result;

        } else {
            //每次取余然后除以10后得到的数
            int a = x*-1;
            //余数放在栈中的数
            long stacknumber = 0;
            while (a > 0) {
                stacknumber = a % 10;
                a = a / 10;
                stack.push(stacknumber);
            }
            //存放结果result
            long result = 0;
            //循环次数
            int j = 0;

            while (!stack.empty()) {
                //第几位；
                int wnumaber = 1;
                for (int i = 0; i < j; i++) {
                    wnumaber *= 10;
                }
                result += (long) stack.peek()*wnumaber;
                stack.pop();
                j++;
            }
            result=-1*result;
            return result;
        }
    }
    //int返回方法上方方法值溢出
    public int reverse1(int x) {
        int rev = 0;
        //整体思想是从后向前取然后每个每个×10加上实现翻转
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        Reverse_Integer test=new Reverse_Integer();
        System.out.println(test.reverse1(1534236469));

    }
}
