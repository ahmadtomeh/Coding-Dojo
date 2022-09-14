'''
Biggie Size - Given a list, write a function that changes all positive numbers in the list to "big".
'''
def BiggieSize(a):
    for i in range(0,len(a),1):
        if a[i] > 0:
            a[i] = "big"
    return a
print("Biggie_Size: ",BiggieSize([1,-2,3,-4]))

'''
Count Positives - Given a list of numbers,
create a function to replace the last value with the number of positive values.
'''

def CountPositives(a):
    count = 0
    for i in range(0,len(a)):
        if a[i] > 0:
            count += 1
            a[len(a)-1] = count
    return a
print("Count_Positives: ", CountPositives([-1,1,1,1]))

'''
Sum Total - Create a function that takes a list and returns the sum of all the values in the list.
'''

def SumTotal(a):
    sum = 0
    for i in range(len(a)):
        sum += a[i]
    return sum
print("Sum_Total :", SumTotal([1,2,3,4]))

'''
Average - Create a function that takes a list and returns the average of all the values.x
'''

def Average(a):
    sum = 0
    for i in range(len(a)):
        sum += a[i]
    return sum / len(a)
print("Average: ", Average([1,2,3,4]))

'''
Length - Create a function that takes a list and returns the length of the list.
'''

def Length(a):
    return len(a)
print("Length: ", Length([]))

'''
Minimum - Create a function that takes a list of numbers and returns the minimum value in the list.
If the list is empty, have the function return False.
'''
def Minimum(a):
    if len(a) == 0:
        return False
    Min = a[0]
    for i in range(0,len(a),1):
        if Min > a[i]:
            Min = a[i]
    return Min
print("Minimum: ", Minimum([5,6,7,1,9,8]))

'''
Maximum - Create a function that takes a list and returns the maximum value in the list.
If the list is empty, have the function return False.
'''

def Maximum(a):
    if len(a) == 0:
        return False
    Min = a[0]
    for i in range(0,len(a),1):
        if Min < a[i]:
            Min = a[i]
    return Min
print("Maximum: ", Maximum([5,6,7,1,9,8]))

'''
Ultimate Analysis - Create a function that takes a list and returns a dictionary that has the sumTotal,
average, minimum, maximum and length of the list.
'''

def UltimateAnalysis(a):
    uN = {"sumTotal" : SumTotal(a), 'average' : Average(a), 'minimum' : Minimum(a), 'maximum' : Maximum(a), 'Length' : Length(a)}
    return uN
print("Ultimate_Analysis: ", UltimateAnalysis([37,2,1,-9]))

'''
Reverse List - Create a function that takes a list and return that list with values reversed.
Do this without creating a second list.
'''

def ReverseList(a):
    for i in range(0,int(len(a)/2)):
        temp = a[i]
        a[i] = a[len(a)-(i+1)]
        a[len(a)-(i+1)] = temp
    return a
print("ReverseList: ", ReverseList([37,2,3,1 ,-9]))