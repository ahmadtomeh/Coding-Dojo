import random
def randInt(min = '' , max = ''):
    num = random.random()
    if min == '' and max == '':
        num = int(random.random() * 100)
    if min == '' and max != '':
        num = int(random.random() * 50)
    if min != '' and max == '':
        num = int(random.random() * (100 - min) + min)
    if min != '' and max != '':
        num = int(random.random() * (max - min) + min)
    return num
print("random integer between 0 to 100 >>>>>>  ", "[", randInt() , "]")
print("random integer between 0 to 50 >>>>>>>  ", "[", randInt(max=50) , "]")
print("random integer between 50 to 100 >>>>>  ", "[", randInt(min=50) , "]")
print("random integer between 50 and 500 >>>>  ", "[", randInt(min=100, max=50) , "]")