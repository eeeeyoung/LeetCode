#include<stdio.h>
#include<stdlib.h>
/*
LeetCode: https://leetcode.com/problems/counting-bits/.
Given a non negative integer number num. For every numbers i in the 
range 0 ≤ i ≤ num calculate the number of 1's in their binary representation 
and return them as an array.
/**/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int countBits(int num){
    // Init
    int bitsArray[num + 1];
    *bitsArray = 0;
    *(bitsArray + 1) = 1;
    int limit = -1;
    int twop = 1;
    for (int a = 1; a < __INT_MAX__; a++) {
        if (2 * twop > num) {
            limit = a - 1;
            break;
        } else {
            twop = twop * 2;
        }
    }

    int twopowers[limit + 1];
    *twopowers = 1;
    for (int power = 1; power <= limit + 1; power++) {
        *(twopowers + power) = 2 * *(twopowers + power - 1);
    }

    int c = 0;
    for (int i = 2; i <= num; i++) {
        if (i >= *(twopowers + c)) {
            printf("i equals %d and two to the power of %d equals %d\n", i, c, *(twopowers + c));
            c += 1;
            *(bitsArray + i) = 1;
        } else {
            *(bitsArray + i) = *(bitsArray + i - *(twopowers + c)) + *(bitsArray + *(twopowers + c));
        }
    }

    return *(bitsArray + 5);
}

void main() {
    printf("The number of 1 at %d is %d\n", 5, countBits(5));
}
