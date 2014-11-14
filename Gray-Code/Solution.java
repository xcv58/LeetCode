import java.util.*;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if (n == 0) {
            list.add(0);
        } else {
            list = this.grayCode(n-1);
            for (int i = list.size() - 1; i >= 0; i--) {
                list.add((1 << (n - 1)) + list.get(i));
            }
        }
        return list;
    }
}
