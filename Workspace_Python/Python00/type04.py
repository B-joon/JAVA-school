# tuple : ()
# 수정 불가능한 list

# 생성자
a = tuple()
print(a)
# a.append(1)
# print(a)
b = tuple([1, 2, '3'])
print(b)

# () 사용
c = (1, 2, 3, 4, 5)
print(c)
c[1] = 'two'
print(c)
