public class Solution {
    public bool IsAnagram(string s, string t) {
        return new string(s.OrderBy(c => c).ToArray()) == new string(t.OrderBy(c => c).ToArray());
    }
}
