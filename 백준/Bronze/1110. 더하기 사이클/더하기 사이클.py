n = int(input())

old = n
new = 0
cycle = 0

while True :
    cycle += 1
    
    new = old % 10 * 10 + (int(old / 10) + old % 10) % 10
    
    if new == n :
        break
    
    old = new

print(cycle)