# 테스트 케이스의 개수 T
t = int(input())

while t > 0 :
    a, b = map(int, input().split())
    
    # A+B를 출력
    print(a + b)
    
    t -= 1