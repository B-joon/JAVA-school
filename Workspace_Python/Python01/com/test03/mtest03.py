# 1. for문을 사용하여 구구단을 출력하는 gugu() 함수를 만들자.
# 2. while문을 사용하여 구구단 중 입력된 단만 출력하는 gugudan(x) 함수를 만들자
# 3. main함수에서, gugu와 gugudan을 호출하는데, input() 함수를 사용하여 단을 입력하여 호출하자

def gugu():
    for i in range(2, 10):
        print("<<"+str(i)+"단>>")
        for j in range(1, 10):
            print(i, ' * ', j, ' = ', i * j)
        print()

def gugudan(x):
    print("<<{}단>>".format(x))
    
    i = 1
    while i < 10:
        print('{} * {} = {}'.format(x, i, x * i))
        i += 1
        
if __name__ == '__main__':
    gugu()
    
    x = input("단을 입력하세요")
    gugudan(int(x))