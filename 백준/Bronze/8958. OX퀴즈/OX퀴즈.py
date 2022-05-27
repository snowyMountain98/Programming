t = int(input())

while t > 0 :
    # OOXXOXXOOO → ['OO', '', 'O', '', 'OOO']
    str = list(input().split('X'))
    
    score = 0
    
    for i in str :
        if len(i) == 0 :
            continue
        score += len(i) * (len(i) + 1) / 2
        
        # +-------+--------+------------+
        # |     i | len(i) |      score |
        # +=======+========+============+
        # |  'OO' |      2 |          3 |
        # +-------+--------+------------+
        # |   'O' |      1 | 3 + 1 =  4 |
        # +-------+--------+------------+
        # | 'OOO' |      3 | 4 + 6 = 10 |
        # +-------+--------+------------+

    print(int(score))
    
    t -= 1