# 산술연산자
a = 21
b = 2
print(a + b)
print(a - b)
print(a * b)
print(a ** b)   # a의 b승
print(a / b)
print(a // b)   # 몫 (floor division)
print(a % b)

# 비교연산자
a, b = 5, 3
print(a == b)
print(a != b)
print(a > b)
print(a >= b)
print(a is b)
print(a is not b)

# 범위연산자
list01 = list(range(100))   # 0 ~ 99
print(list01)

# [start: end] -> start ~ end-1
# [start: end: step] -> start ~ end-1 까지 step만큼씩
print(list01[12: 50])
print(list01[12: 49: 3])

start01 = 'Hello World!'
print(start01[0])
print(start01[0: 5])
print(start01[6: 11])
print(start01[6: ])

# -1
print(start01[-1])
print(start01[-1:])
print(start01[: -1])
print(start01[:: -1])

# in, not in
start02 = [1, 2, 3, 4, 5, 6]
print(3 in start02)
print(6 not in start02)
print(9 not in start02)