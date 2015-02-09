public class Solution {
    public String reverseWords(String s) {
        String[] tokens = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            sb.append(tokens[i]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}
