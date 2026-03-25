package hot100.stack.a1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * @create 2026/3/25 14:56
 */
public class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        Deque<Character> deque=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('){
                deque.push(c);
            }
            if(c=='{'){
                deque.push(c);
            }
            if(c=='['){
                deque.push(c);
            }
            if(c==')'){
                if(deque.isEmpty()||deque.pop()!='(') return false;
            }
            if(c=='}'){
                if(deque.isEmpty()||deque.pop()!='{') return false;
            }
            if(c==']'){
                if(deque.isEmpty()||deque.pop()!='[') return false;
            }
        }
        return deque.isEmpty();
    }
}
