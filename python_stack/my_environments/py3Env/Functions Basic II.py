#Countdown - Create a function that accepts a number as an input.
#Return a new list that counts down by one,
# from the number (as the 0th element) down to 0 (as the last element).

from itertools import count


def countdown(num):
    l = []
    a=0
    for num in range(num,-1,-1):
        l.insert(a, num)
        a+=1
    return l
print(countdown(10))

#Print and Return - Create a function that will receive a list with two numbers.
#Print the first value and return the second.

def FC(a):
    print(a[0])
    return a[1]
print(FC([1,2]))

#First Plus Length - Create a function that accepts a list
#and returns the sum of the first value in the list plus the list's length.

def firstPlusLingth(a):
    sum = len(a) + a[0]
    return sum
print(firstPlusLingth([1,2,3,4,5]))

#Values Greater than Second - Write a function that accepts a list
# and creates a new list containing only the values from the original list that are greater than its 2nd value.
# Print how many values this is and then return the new list.
# If the list has less than 2 elements, have the function return False

def valuesGreaterThanSecond(List_1):
    List_2 = []
    count = 0
    if len(List_1) < 2:
        return False
    else:
        for i in range(0,len(List_1)):
            if List_1[1] < List_1[i]:
                List_2.append(List_1[i])
                count += 1
        print(count)
        return List_2
print(valuesGreaterThanSecond([5,2,3,2,1,4]))

#This Length, That Value - Write a function that accepts two integers as parameters: size and value.
#The function should create and return a list whose length is equal to the given size,
#and whose values are all the given value.

def tLtV(size, value):
    List1 = []
    for i in range(0,size):
        List1.append(value)
    return List1
print(tLtV(6,2))