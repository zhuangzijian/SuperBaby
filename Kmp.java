package LeetCode;

public class Kmp {
    /**https://www.cnblogs.com/yjiyjige/p/3263858.html
     * 暴力破解法
     * @param ts 主串
     * @param ps 模式串
     * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
     * 大致思路就县对比第一个如果对比上对比模式串第二个 如果对比不上则进行下一个主串进行对比
     */
    public static int bf(String ts, String ps) {
        char[] t=ts.toCharArray(); //把当前的字符串编程一个char的数组
        char[] p=ps.toCharArray();
        int i=0;  //用来遍历主串和模式串
        int j=0;
        while (i<t.length&&j<p.length){
            if (t[i]==p[j]){//如果相等的话进行比下一个字符
                i++;
                j++;
            }else{//如果不相等的话则进行比主字符串的下一个模式串从头开始
                i-=j;
                j=0;
            }
        }
        if(j==p.length){//判断如果i走的和p的长度一样那么进行返回  由于一样j最后一个也会进行++运算所以它会等于其长度
            return i-j+1;
        }else {
            return -1;
        }
    }
}
