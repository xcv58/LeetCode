public class Solution {
    public boolean isNumber(String s) {
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

}
