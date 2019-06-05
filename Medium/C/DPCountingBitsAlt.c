#include <stdlib.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 * 
 * This shifting solution does not work, stringent on time limit :)
 */
int* countBits(int num, int* returnSize){
    int count;
    returnSize = malloc(sizeof(int) * (num + 1));
    for (int i = 0; i <= num; i++) {
        count = 0;

        // for loop to left shift and check how many one bit in binary
        for (int j = 0; j < 31; j++) {
            // provided non negative, therefore sign bit is 0
            count += ((i >>= j) & 0x1);
        }

        *(returnSize + i) = count;
    }
    return returnSize;
}
