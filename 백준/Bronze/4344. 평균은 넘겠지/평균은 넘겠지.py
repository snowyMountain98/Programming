c = int(input())

while c > 0 :
    # 학생의 수 N, N명의 점수
    score = list(map(int, input().split()))
    
    # 평균
    avg = sum(score[1:]) / (len(score) - 1)
    
    # 평균을 넘는 학생들
    abvAvrgStdn = 0
    for i in score[1:] :
        if i > avg :
            abvAvrgStdn += 1
    
    # 비율
    prcnt = abvAvrgStdn / (len(score) - 1) * 100
    
    # 소수점 셋째 자리까지 출력
    print("%.3f%%" % (prcnt))
    
    c -= 1