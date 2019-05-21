#include<stdio.h>
/*
LeetCode: https://leetcode.com/problems/maximum-subarray/.
Given an integer array nums, find the contiguous 
subarray (containing at least one number) which has the largest sum and return its sum.
/**/
int maxSubArray(int* nums, int numsSize){
    // Initializations
    int cumSum[numsSize];
    *(cumSum) = *(nums);
    int max = -1;
    int maxIndex = 0;
    int min = 2 ^ 31;
    int minIndex = 0;

    for (int i = 1; i < numsSize; i++) {
        *(cumSum + i) = *(nums + i) + *(cumSum + i - 1);
        // Get the max index (right bound) of the subarray
        if (*(cumSum + i) > max) {
            max = *(cumSum + i);
            maxIndex = i;
        }
        // Get the min index (left bound) of the subarray
        if (*(cumSum + i) < min) {
            min = *(cumSum + i);
            minIndex = i;
        }
    }

    printf("The maxIndex is %d\n", maxIndex);
    printf("The minIndex is %d\n", minIndex);  // left bound should in fact be minIndex + 1
    
    return *(cumSum + maxIndex) - *(cumSum + minIndex);  // but for calculation of sum, use minIndex
}

void main() {
    int array[] = {-2,1,-3,4,-1,2,1,-5,4};
    printf("The sum of the maximum subarray is %d\n", maxSubArray(array, 9));
}
