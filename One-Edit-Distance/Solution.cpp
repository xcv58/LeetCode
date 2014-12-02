class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        int ls = s.size();
        int lt = t.size();
        if (abs(ls - lt) > 1) {
            return false;
        }

        int si = 0, ti = 0;
        for (; si < ls && ti < lt; si++, ti++) {
            if (s.at(si) != t.at(ti)) {
                for (int i = si + (ls - si >= lt - ti ? 1 : 0), j = ti + (ls - si <= lt - ti ? 1 : 0); i < ls && j < lt; i++, j++) {
                    if (s.at(i) != t.at(j)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return abs(ls - si - lt + ti) == 1;
    }
};
