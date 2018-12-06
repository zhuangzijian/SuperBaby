package LeetCode;

/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
回文数字
思路一：
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        //存放反向结果

        int a = 0;
        if (x  < 0) return false;

        int m=x;
        while (m >= 10) {
            int b = m % 10;
            a += b;
            a *= 10;
            m/= 10;
        }
        a += m;
        if (a == x) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsPalindrome a = new IsPalindrome();
        a.isPalindrome(121);
    }
}
