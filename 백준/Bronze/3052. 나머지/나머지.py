remainder = set()

for i in range(10) :
    remainder.add(int(input()) % 42) # 42로 나눈 나머지
    
print(len(remainder))