a, b, c = map(int, input().split())

prize = 0

# 같은 눈이 3개
if a == b and b == c :
    prize = 10000 + a * 1000
# 같은 눈이 2개
elif a == b :
    prize = 1000 + a * 100
elif b == c :
    prize = 1000 + b * 100
elif c == a :
    prize = 1000 + c * 100
# 모두 다른 눈
else :
    prize = max([a, b, c]) * 100
    
print(prize)