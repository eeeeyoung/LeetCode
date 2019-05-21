#include <stdbool.h>
#include <stdio.h>
/*
Given an array with n integers, your task is to check if it
could become non-decreasing by modifying at most 1 element.

Sol: As before, let pp be the unique problem index for which \text{A[p]} > \text{A[p+1]}A[p]>A[p+1]. If this is not unique or doesn't exist, the answer is False or True respectively. We analyze the following cases:
If \text{p = 0}p = 0, then we could make the array good by setting \text{A[p] = A[p+1]}A[p] = A[p+1].
If \text{p = len(A) - 2}p = len(A) - 2, then we could make the array good by setting \text{A[p+1] = A[p]}A[p+1] = A[p].
Otherwise, \text{A[p-1], A[p], A[p+1], A[p+2]}A[p-1], A[p], A[p+1], A[p+2] all exist, and:
We could change \text{A[p]}A[p] to be between \text{A[p-1]}A[p-1] and \text{A[p+1]}A[p+1] if possible, or;
We could change \text{A[p+1]}A[p+1] to be between \text{A[p]}A[p] and \text{A[p+2]}A[p+2] if possible.
*/
bool checkPossibility(int* nums, int numsSize) {
    int flagged = -1;
    for (int i = 0; i < numsSize - 1; i++) {
        /* if not already swapped, and decreasing i vs i + 1 */
        if (*(nums + i) > *(nums + i + 1)) {
            if (flagged != -1) {
                return false;
            }
            flagged = i;
        }
    }
    if (flagged == -1 || flagged == 0 || flagged == numsSize - 2 || *(nums + flagged - 1) <= *(nums + flagged + 1) || *(nums + flagged) <= *(nums + flagged + 2)) {
        return true;
    } else {
        return false;
    }
}

void main() {
    int var[3] = {4, 2, 3};
    if (checkPossibility(var, 3)) {
        printf("True");
    } else {
        printf("False");
    }
}