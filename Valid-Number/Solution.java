public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int len = s.length();
        int i = 0;

        boolean plusOrMinus = false;
        boolean dot = false;
        boolean digital = false;
        boolean exp = false;
        int num = 0;

        while (i < len) {
            char c = s.charAt(i);
            switch (c) {
            case '+': case '-':
                if (plusOrMinus || digital) {
                    return false;
                }
                plusOrMinus = true;
                break;
            case '.':
                if (dot) {
                    return false;
                }
                dot = true;
                plusOrMinus = true;
                digital = false;
                break;
            case 'e': case 'E':
                if (exp || num == 0) {
                    return false;
                }
                exp = true;
                dot = true;
                plusOrMinus = false;
                digital = false;
                break;
            default:
                if (c >= '0' && c <= '9') {
                    digital = true;
                    num++;
                } else {
                    return false;
                }
            }
            i++;
        }

        return (exp && digital) || (!exp && num > 0);
    }


    // regex version, it's cheating.
    public boolean isNumber1(String s) {
        s = s.replaceAll("^\\s*", "");
        s = s.replaceAll("\\s*$", "");
        boolean result;
        result = s.matches("[+-]?\\.\\d+");
        if (result) {
            return result;
        }
        result = s.matches("[+-]?\\d+\\.?");
        if (result) {
            return result;
        }
        result = s.matches("[+-]?\\d+[\\.e][+-]?\\d+");
        if (result) {
            return result;
        }
        result = s.matches("[+-]?\\d+\\.[e][+-]?\\d+");
        if (result) {
            return result;
        }
        result = s.matches("[+-]?\\d*\\.\\d+[e][+-]?\\d+");
        if (result) {
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{
            " ",
            "1 ",
            "a",
            "e",
            "e9",
            ".e9",
            "0e",
            "1.0",
            "2.",
            ".",
            "-1.0",
            "  -1.0",
            "6+1",
            ".3e",
            "3e",
            ".-4",
            "-.4",
            "46.e3",
            "32e8 .616 ",
            "459277e38+",
            ". ",
            "3.0"
        };
        for (String tmpStr : strs) {
            boolean b1 = s.isNumber(tmpStr);
            boolean b2 = s.isNumber1(tmpStr);
            if (b1 != b2) {
                System.out.println(tmpStr + "\n" + b1);
                System.out.println(b2);
                System.out.println();
            }
        }
    }
}
