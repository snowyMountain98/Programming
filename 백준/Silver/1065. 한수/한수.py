n = int(input())

hansu = 0

for i in range(1, n + 1) :
    if i < 100 :
        hansu += 1
    else :
        digit = list(map(int, str(i)))
        if digit[2] - digit[1] == digit[1] - digit[0] :
            hansu += 1

print(hansu)