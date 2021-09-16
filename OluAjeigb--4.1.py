

#import permutations from the itertools package
from itertools import permutations
#importing factorials from the math package
from math import factorial
#n is the interger value input for our factorial
n=int(input())
print(factorial(n))

#creating a for lup to iterate from index 1 to n+1
#placing the value of the forloop into values
values=[i for i in range(1,n+1)]
#all permutations from the list
setofValues=permutations(values)
#forloop that will iterate through the set of values and print each one
for i in setofValues:
   print(*i)
