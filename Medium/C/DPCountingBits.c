#include <stdlib.h>
#include <stdio.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 * 
 * https://leetcode.com/problems/counting-bits/
 * 
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate 
 * the number of 1's in their binary representation and return them as an array.
 *
 * Solution:
 * 
 * DP: Idea is that the 2n is just arithmetic left shift of n, 
 * so they should have identical number of 1 bits in their binary representation
 * 
 * However, a twist when calculating n/2 from n, n/2 gets rounded towards 0 (floor) automatically
 * therefore, if n % 2 == 1, then n is odd so one extra 1 bit is needed in the lowerest order bit.
 * 
 * if n % 2 == 0, the left shift (<<1) is good enough, same number of bits as n / 2 
 *  
 * bar the highest order bit. (All non negatives)
 * 
 */
int* countBits(int num, int* returnSize){
    
    // Initializations
    returnSize = malloc(sizeof(int) * (num + 1));

    // Base cases
    *returnSize = 0;

    // Loop
    for (int i = 1; i <= num; i++) {
        *(returnSize + i) = i % 2 + *(returnSize + (i >> 1));
    }

    return returnSize;
}

void main() {
    int* returnSize;
    int num;
    num = 5;
    returnSize = countBits(num, returnSize);
    for (int a = 0; a <= num; a++) {
        printf("The number at position %d is %d\n", a, *(returnSize+a));
    }
}