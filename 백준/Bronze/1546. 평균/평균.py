# 시험 본 과목의 개수 N
n = int(input())

# 현재 성적
score = list(map(int, input().split()))

# 점수 / M * 100
newScore = list(map(lambda x : x / max(score) * 100, score))

print(sum(newScore) / len(newScore))