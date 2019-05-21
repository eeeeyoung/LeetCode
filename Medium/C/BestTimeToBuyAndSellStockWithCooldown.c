#include<stdio.h>
#define INT_MIN -2147483648
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Solution: dynamic programming?
/**/
int MAX(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
int maxProfit(int* prices, int pricesSize){
    int buy[pricesSize];
    int sell[pricesSize];
    int rest[pricesSize];

    *(buy) = -*(prices);
    *(sell) = INT_MIN;
    *(rest) = 0;
    for (int i = 1; i < pricesSize; i++) {
        *(buy + i) = MAX(*(buy + i - 1), *(rest + i - 1) - *(prices + i));
        *(sell + i) = *(buy + i - 1) + *(prices + i);
        *(rest + i) = MAX(*(rest + i - 1), *(sell + i - 1));
    }
    return MAX(*(rest + pricesSize -1), *(sell + pricesSize -1));
}

void main() {
    int prices[5] = {1, 2, 3, 0, 2};
    int pricesSize = 5;
    printf("%d\n", maxProfit(prices, pricesSize));
}