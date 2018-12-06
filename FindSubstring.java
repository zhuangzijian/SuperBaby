package LeetCode;

import recursionDG.Fibonacci;

import java.util.ArrayList;
import java.util.List;

/*
给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1:
输入:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出: [0,9]
解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
 */
/*
思路：切割s 为words的字符总长度 判断切割得到的字符串是否包含
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if (words.length<=0||s==null)return result;
        int sub=words[0].length();
        int sizes=words.length;
        for (int i = 0; i <=s.length()-sub*sizes; i+=1) {
            List <String> juge=new ArrayList<>();
            String sub1=s.substring(i,i+sub*sizes);
            for (int j = 0; j <sizes*(sub) ; j+=sub) {
                juge.add( sub1.substring(j,j+sub));
            }
            /*for (int j = 0; j <words.length ; j++) {
                       juge.remove(words[j]);
            }*/
            int left=0,right=sizes-1;
            while(left<=right){
                juge.remove(words[left]);
                juge.remove(words[right]);
                left++;
                right--;
            }
            if (juge.size()==0){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindSubstring a=new FindSubstring();
        String[] aa= {"fooo","barr","wing","ding","wing"};
        System.out.println(a.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake" ,aa));
    }
}
