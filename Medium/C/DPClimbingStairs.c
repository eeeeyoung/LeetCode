/*
LeetCode: https://leetcode.com/problems/min-cost-climbing-stairs/.
You are climbing a stair case. It takes n steps to reach to the top
Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
/**/
int climbStairs(int n){
    // Initialization
    int ways[n + 1];

    // base case
    *(ways) = 0;
    *(ways + 1) = 1;
    *(ways + 2) = 2;
    for (int i = 3; i <= n; i++) {
        *(ways + i) = *(ways + i - 2) + *(ways + i - 1);
    }
    return *(ways + n);
}

int main(int n) {
    printf("The number of distinct ways of climbing to the top: %d\n", climbStairs(4));
}