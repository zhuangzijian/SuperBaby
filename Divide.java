package LeetCode;

public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor==1)return dividend;
        if(divisor==-1) {
            long m=-1;
                long juge=m*dividend;
                int result=ju(juge);
           return  result;
        }
        //符号
        int f=1;
        long result=0;
        long dividend1=dividend;
        long divisor1=divisor;
        if(dividend1<0)f*=-1;
        if(divisor1<0)f*=-1;
        dividend1=Math.abs(dividend1);
        divisor1=Math.abs(divisor1);
        if(dividend1<divisor1)return 0;
     while (true){
         if (dividend1<divisor1)break;
         dividend1-=divisor1;
         result++;
     }
     int a=ju(result*f);
     return a;
    }
public int ju(long juge){
    if (juge>Integer.MAX_VALUE)return Integer.MAX_VALUE;
    if (juge<Integer.MIN_VALUE)return Integer.MIN_VALUE;
    return (int)juge;
}
    public static void main(String[] args) {
        Divide a=new Divide();
        System.out.println(a.divide(-2147483648  , -1 ));
    }
}
