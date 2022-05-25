# 현재 시각 시 A와 분 B
a, b = map(int, input().split())

# 요리하는 데 필요한 시간 C
c = int(input())

b += c

while b >= 60 :
    a += 1
    if a > 23 : a = 0
    b -= 60

print(a, b)