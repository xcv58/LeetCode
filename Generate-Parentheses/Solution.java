import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n == 1) {
            list.add("()");
        }

        for (int i = 0; i < n - 1; i++) {
            List<String> tmpListLeft = this.generateParenthesis(i);
            List<String> tmpListRight = this.generateParenthesis(n - i - 1);
            for (String tmpStrLeft : tmpListLeft) {
                for (String tmpStrRight : tmpListRight) {
                    list.add("(" + tmpStrLeft + ")" + tmpStrRight);
                }
            }
        }

        if (n > 1) {
            for (String tmpStr : this.generateParenthesis(n - 1)) {
                list.add("(" + tmpStr + ")");
                list.add("()" + tmpStr);
            }
        }
        return list;
    }
}
