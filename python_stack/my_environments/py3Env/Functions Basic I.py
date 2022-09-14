#1
def a():
    return 5
print(a())

#5

########################################################################
#2
def a():
    return 5
print(a()+a())

#10

########################################################################
#3
def a():
    return 5
    return 10
print(a())

#5

########################################################################
#4
def a():
    return 5
    print(10)
print(a())

#5

#########################################################################
my_dict = { "name": ["Noelle","thabrt" ],"language":[ "Python","hhh" ,"c"]}
for i in my_dict:
    count=0
 
     
    for x in range(0,len(my_dict[i])):
        count=count+1
        print(count,i ,"\r" ,my_dict[i][x])
    # print(count,i)     

        
        
        
       
        


