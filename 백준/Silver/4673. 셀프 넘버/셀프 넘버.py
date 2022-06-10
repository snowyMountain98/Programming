def d(n) :
    sum = n
    
    while n > 0 :
        sum += n % 10;
        n = int(n / 10);

    return sum;

selfNumber = [1 for i in range(10001)]

for i in range(1, 10001) :
    num = d(i)
	
    if num <= 10000 :
	    selfNumber[num] = 0;

for i in range(1, 10001) :
    if selfNumber[i] == 1 :
        print(i)