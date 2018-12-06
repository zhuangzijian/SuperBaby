package LeetCode;

import java.util.Stack;
/*
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int result=0;
        int start=0;
        //创建一个栈
        Stack<Integer> stack=new Stack();
        for (int i = 0; i <s.length() ; i++) {
            char a=s.charAt(i);
            if (a=='('){
                stack.push(i);
            }else {
                if(stack.empty()){
                    start = i + 1;

                    continue;

                }else {
                    stack.pop();
                   // if (!stack.empty()&&s.length()%2!=0)  aa=0;
                    result = stack.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParentheses a=new LongestValidParentheses();
        System.out.println(a.longestValidParentheses(")()())" ));
    }
}
