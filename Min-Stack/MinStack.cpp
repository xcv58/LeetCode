#include <stack>

using namespace std;

class MinStack {
    stack<int> elements;
    stack<int> minStack;

public:
    void push(int x) {
        elements.push(x);
        if (minStack.empty() || minStack.top() >= x) {
            minStack.push(x);
        }
        return;
    }

    void pop() {
        if (elements.top() <= minStack.top()) {
            minStack.pop();
        }
        elements.pop();
        return;
    }

    int top() {
        return elements.top();
    }

    int getMin() {
        return minStack.top();
    }
};

int main() {
  return 0;
}
