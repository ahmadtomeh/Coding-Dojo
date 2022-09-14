for i in range(0,151,1):
    print(i)


for x in range(5,1001,5):
    print(x)


for z in range(1,101,1):
    if z % 5 == 0:
        print("Coding")
    if z % 10 == 0:
        print("Coding Dojo")
    else:
        print(z)


x = 0
for y in range(1,500001,2):
    x += y
print(x)


for a in range(2018,0,-4):
    print(a)

lowNum = 2
highNum = 9
mult = 3
for i in range(lowNum,highNum+1,1):
    if i % mult == 0:
        print(i)
