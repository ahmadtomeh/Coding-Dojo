def is_leap_year(y):
    if y % 2 == 0 and y % 4 == 0 and y % 100 == 0 and y % 400 == 0:
        return True
    else:
        return False
print(is_leap_year(1600))
#-----------------------------------------------------------------------
def count_substring(string, sup_string):
    count = 0
    for i in range(len(string)):
        if string[i:i+len(sup_string)] == sup_string:
            count += 1
    print(count)
    
count_substring("i can can the can ", "can")
