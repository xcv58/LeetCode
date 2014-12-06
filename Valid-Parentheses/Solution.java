import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.isLeft(c)) {
                stack.push(c);
                continue;
            }
            if (stack.empty() || this.notMatch(stack.pop(), c)) {
                return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean notMatch(char c, char d) {
        return !((c == '(' && d == ')') || (c == '{' && d == '}') || (c == '[' && d == ']'));
    }
}
