package LeetCode;

public class LongestString {
    //最长回文字串
    public String longestPalindrome(String s) {
        /*
        方法四：中心扩展算法
       事实上，只需使用恒定的空间，我们就可以在 O(n2)O(n^2)O(n​2​​) 的时间内解决这个问题。
        我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n−12n - 12n−1 个这样的中心。
        你可能会问，为什么会是 2n−12n - 12n−1 个，而不是 nnn 个中心？
        原因在于所含字母数为偶数的回文的中心可以处于两字母之间
        （例如 “abba”\textrm{“abba”}“abba” 的中心在两个 ‘b’\textrm{‘b’}‘b’ 之间）。
         */
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        LongestString test=new LongestString();
        String s="abba";
       String result=test.longestPalindrome(s);
        System.out.println(result);
    }
}
