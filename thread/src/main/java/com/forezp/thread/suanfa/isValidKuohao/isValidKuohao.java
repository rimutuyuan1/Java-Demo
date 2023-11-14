package com.forezp.thread.suanfa.isValidKuohao;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-01  20:40
 **/
public class isValidKuohao {

    public static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public static void main(String[] args) {
        isValidKuohao s = new isValidKuohao();
        System.out.println(s.isValid("([}}])"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            //如果字符数组的第一个元素是有括号，直接返回false
            char c = charArray[i];
            if (i == 0 && (c == ')' || c == '}' || c == ']')) {
                return false;
            }
            if (c == '{' || c == '(' || c == '[') {
                //此时c是左括号，直接进栈
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                //此时c是右括号，需要看下栈顶元素top和c是否是匹配的（栈中全部为左括号，右括号整个过程中都不会进栈）
                //如果此时栈是空的，直接返回false即可
                if (stack.isEmpty()) {
                    return false;
                }
                //根据peek出来的左括号去拿右括号
                char c1 = map.get(stack.peek());
                if (c != c1) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
