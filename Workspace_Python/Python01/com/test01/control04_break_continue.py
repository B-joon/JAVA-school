i = 1

while i <= 10:
    if i > 5:
        break
    print(i)
    i += 1
else:
    print('i', i, sep=':')
    
for i in range(1, 10):
    if i % 2 == 0:
        continue
    print(i)
else:
    print('i', i, sep=':')