#include <unordered_map>

using namespace std;

class TwoSum {
    unordered_map<int,int> map;
public:
        void add(int number) {
            map[number] = map.find(number) == map.end() ? 1 : map[number] + 1;
        }

        bool find(int value) {
        for (unordered_map<int,int>::iterator it = map.begin(); it != map.end(); it++) {
                int i = it->first;
                int j = value - i;
                if ((i == j && it->second > 1) || (i != j && map.find(j) != map.end())) {
                    return true;
                }
            }
            return false;
        }
};

int main(int argc, char *argv[]) {
    return 0;
}
