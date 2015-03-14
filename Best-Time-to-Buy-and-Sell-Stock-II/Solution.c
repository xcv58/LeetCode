int maxProfit(int prices[], int n){
    int result = 0;
    for (int i = 0; i < n - 1; i++) {
        if (prices[i] < prices[i + 1]) { result += prices[i + 1] - prices[i]; }
    }
    return result;
}
