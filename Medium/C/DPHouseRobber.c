#include<stdio.h>
/*
LeetCode: https://leetcode.com/problems/house-robber/
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you 
from robbing each of them is that adjacent houses have security system connected 
and it will automatically contact the police if two adjacent houses were broken into 
on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
/**/
int max(int a, int b);

int rob(int* nums, int numsSize){
    //Init
    int robbed[numsSize];
    *robbed = *nums;
    *(robbed + 1) = max(*(nums + 1), *nums);

    // Loop
    for (int i = 2; i < numsSize; i++) {
        *(robbed + i) = max(*(robbed + i - 2) + *(nums + i), *(robbed + i - 1));
    }

    printf("The maximum amount of robbery is: %d\n", *(robbed + 4));
}

int max(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}

void main() {
    int houses[] = {2,7,9,3,1};
    rob(houses, 5);
}