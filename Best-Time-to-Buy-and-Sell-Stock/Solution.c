#include <limits.h>

int maxProfit(int prices[], int n){
    int result = 0;
    for (int i = 0, low = INT_MAX; i < n; i++) {
        low = low < prices[i] ? low : prices[i];
        result = result > prices[i] - low ? result : prices[i] - low;
    }
    return result;
}
