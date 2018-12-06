package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class KuoHao {
    public boolean isValid(String s) {
        HashMap<Character,Character> juge = new HashMap();
        juge.put(')', '(');
        juge.put('}', '{');
        juge.put(']', '[');
        Stack<Character> res = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            if (juge.containsKey(k)) {
                if (res.isEmpty()) {
                    return false;
                } else {
                    char m = res.pop();
                    if (m != juge.get(k)) {
                        return false;
                    }
                }
            } else {
                res.push(s.charAt(i));
            }


        }

        return res.empty();
    }
}
