def reverse(x: int) -> int:
    reversed = 0
    while x != 0:
        temp = reversed * 10 + x % 10
        if temp / 10 != reversed:
            return 0  #overflow of integer
        reversed = temp
        x /= 10
    return reversed


i = 2**40
print(9646324351 > 2 ** 31 - 1)
