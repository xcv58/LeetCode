import java.util.*;

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>(strs.length);

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            Integer count = map.get(sorted);
            if (count == null) {
                map.put(sorted, -i);
            } else {
                if (count <= 0) {
                    list.add(strs[-count]);
                    map.put(sorted, i + 1);
                }
                list.add(strs[i]);
            }
        }
        return list;
    }
}
