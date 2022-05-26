a = int(input())
b = int(input())
c = int(input())

# A × B × C를 계산한 결과
abc = a * b * c

# 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지
num = [0 for i in range(10)]

while abc > 0 :
    num[abc % 10] += 1
    
    abc = int(abc / 10)
    
for i in num :
    print(i)