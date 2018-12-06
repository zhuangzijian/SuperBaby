package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumeber {
    static List<List<Character>> res;
    static StringBuffer results =new StringBuffer();;
    static List<String> cc;
    static  List<List<Character>> datas=new ArrayList<>();;
    public List<String> letterCombinations(String digits) {
        res=new ArrayList<>();
        StringBuffer results =new StringBuffer();
        cc=new ArrayList<>();

        /*

        大致的思路：一个数字为一个数组数组中是长度为三的封装成List<char[3]>的数组；
        */
        if(digits.length()<=0){
            return new ArrayList<String>();
        }
        if (datas.size()!=8){
            //首先把相应的数字对应的字母放到相应的数组中去while就是
        for(int i=0;i<26;){
           List<Character>strings=new ArrayList<>();
            strings.add ((char)(97+i));
            ++i;
            strings.add((char) (97+i));
            ++i;
            strings.add ((char) (97+i));
           ++i;
            if(i==18||i==25){
                strings.add((char) (97+i));
                ++i;
            }
            datas.add(strings);
        }
        }
        //因为是从2开始所有m-2，res为存放相应数字对应的字符数组放到结果集中
        for(int j=0;j<digits.length();j++){
            int m=digits.charAt(j)-48;
            res.add(datas.get(m-2));
        }
        stringpj(0);
        return cc;


    }

    //回溯法 取值 匹配 并放入到最终结果集中
    public void stringpj(int n) {

        for (int i = 0; i <res.get(n).size() ; i++) {
            if (n == res.size()-1) {
                 cc.add(results.toString()+ res.get(n).get(i) +"");
            } else {

                /*if(n>0&&i!=0){
                  results.deleteCharAt(results.length()-1);
                }*/
                 results.append( res.get(n).get(i) +"" ) ;
                 stringpj(n + 1);

            }
            //新的首位字母比如（“23”）中的af完成后be防止abe出现，开始要把字符串初始化
            if (n==0)results=new StringBuffer();
            //每次最后一个循环后把字符串中的最后一个数据删除不然会出现（“222”）aac,abaa的问题
            if(n!=0&&i==res.get(n).size()-1&&results.length()!=0)results.deleteCharAt(results.length()-1);
        }

    }

    public static void main(String[] args) {
        PhoneNumeber a=new PhoneNumeber();
       // System.out.println(a.letterCombinations("23"));
      //  System.out.println(a.letterCombinations("2"));
        System.out.println(a.letterCombinations("2345"));
    }
}
