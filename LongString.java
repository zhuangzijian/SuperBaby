package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongString {
    //无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        //第一种方法暴力法
       /* int n = s.length();
        int rusout = 0;
        //遍历所有的字符 枚举 出所有 s 下的子字符串
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                //放入到函数中 检查一个字符串是否有重复字符
                if (allUnique(s, i, j)) {
                    //几个字符 和 之前算出的最大字符比较  取出当中的最大值
                    rusout = Math.max(rusout, j - i);
                }
            }
        }
        return rusout;*/


       //第二种方法 滑动窗口KMP

      /*  int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //判断是否重复
            if (!set.contains(s.charAt(j))){
            //不重复则放到set中 然后j++
                set.add(s.charAt(j++));
                //更新子子字符串的长度
                ans = Math.max(ans, j - i);
            }
            else {
                //有重复的拿出来
                set.remove(s.charAt(i++));
            }
        }
        return ans;*/
      //n存放s的长度 ， ans存放最终最长子字符串
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of characte   HashMap 比 HashSet更快
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            //当我们找到重复的字符时，我们可以立即跳过该窗口。
            //也就是说，如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与 j'j
            //​​  重复的字符，我们不需要逐渐增加 ii 。 我们可以直接跳过 [i，j′] 范围内的所有元素，并将 ii 变为 j' + 1j
            //​​ +1。 检查最前面的一个 如果有重复直接让 后面的跳过去
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }

    public boolean allUnique(String s, int start, int end) {
        //创建set进行存放不同元素的集合  并用其中的contatins方法进行判断是否有重复的字符
        Set<Character> set = new HashSet<>();
        for (int i = start; i <end ; i++) {
            //分割出所对应的子字符
            Character ch=s.charAt(i);
            //用set函数来进行判断是否有重复的字符
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        LongString test = new LongString();
        int a = test.lengthOfLongestSubstring("abcabcbb");
        System.out.println(a);
    }
}
