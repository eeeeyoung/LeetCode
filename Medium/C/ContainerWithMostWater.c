#include<stdio.h>
/*
Given n non-negative integers a1, a2, ..., an , where each represents 
a point at coordinate (i, ai). n vertical lines are drawn such that 
the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container 
contains the most water.
/**/
int calculateArea(int a, int b, int c);

int maxArea(int* height, int heightSize) {
    int fwd = heightSize - 1;
    int bwd = 0;
    int maxArea = calculateArea(*(height + bwd), *(height + fwd), fwd - bwd);
    while (bwd < fwd)
    {
        if (*(height + bwd) < *(height + fwd)) {
            bwd++;
        } else {
            fwd--;
        }
        int temp = calculateArea(*(height + bwd), *(height + fwd), fwd - bwd);
        if (maxArea < temp) {
            maxArea = temp;
        }
    }
    return maxArea;
}

int calculateArea(int a, int b, int c) {
    if (a > b) {
        return b * c;
    } else {
        return a * c;
    }
}

void main() {
    int height[9] = {1, 8, 6, 2, 5 ,4, 8, 3, 7};
    int heightSize = 9;
    int max;
    max = maxArea(height, heightSize);
    printf("%d\n", max);
}