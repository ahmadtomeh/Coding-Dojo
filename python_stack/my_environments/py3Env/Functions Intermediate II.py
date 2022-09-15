from typing import Text

x = [ [5,2,3], [10,8,9] ] 
x [1][0] = 15
print(x)

print("\n","*" * 100, "\n")

#**************************************************************************************************** 

students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
students[0]['last_name'] = 'Bryant'
print (students)

print("\n","*" * 100, "\n")

#**************************************************************************************************** 

sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
sports_directory['soccer'][0] = 'Andres'
print(sports_directory)

print("\n","*" * 100, "\n")

#**************************************************************************************************** 

z = [ {'x': 10, 'y': 20} ]
z [0]["y"] = 30
print(z)

print("\n","*" * 100, "\n")

#**************************************************************************************************** 

students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
def iterateDictionary(students):
    a = ''
    for i in range(0,len(students)):
        a =students[i]
        print( "first_name -", a['first_name']+",", "last_name -", a['last_name'])
    for k in students[0]:
        print(k)
iterateDictionary(students)

print("\n","*" * 100, "\n")

#**************************************************************************************************** 

def iterateDictionary2(key_name, students):
    for i in range(0,len(students)):
        a =students[i]
        print(a[key_name])
iterateDictionary2('last_name',students)

print("\n","*" * 100, "\n")

#**************************************************************************************************** 

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
def printInfo(dojo):
    count=0
    for k in dojo:
        for x in range(len(dojo[k]) ):
            count+=1
        print(count,Text.upper(k))
        for j in range(len(dojo[k])):
            count=0
            print(dojo[k][j])
printInfo(dojo)

