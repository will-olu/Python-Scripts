#Open IDLE 3.x (see videos for laptop installation tips)
#From shell
print("Hello world!")

#Try from shell
#common errors
print(Hello world)
prin("Hello world")
print("Hello
      world")
# how to include a new line in the middle of a string
print("Hello\nworld")

#Python Data Types You Should Know
#1. Strings:
a = 'hello'
#get the type of an object with type function
type(a)
#get length of string with len function
len(a)
#assign 'world' to variable b
b = 'world'
#concatenate strings
a+b
a + ' ' + b

#2. Lists:
#assign a list of strings to the variable colors
colors = ['red','blue','green','yellow']
#get the type of an object with type function
type(colors)
#get length of a list
len(colors)
#pull out list item at index 1
colors[1]
#pull out list item at index 0
colors[0]

#Note: Python Indexing Begins at 0
#string indexing pulls out character
a[0]
#list indexing pulls out item
colors[0]

type(a)
type(colors)

#number types
#3. Integers:
x = 3
type(x)
#4. Floats:
y = 4.5
type(y)

2+3
5-3
2*6
13/5
2**2 #exponents
2**3
x+y
z = y**x
type(z)
print(z)
13//5 #integer division
13%5 #remainder

#we can also make lists of numbers
scores = [88, 96, 73.5]
#get length of a list
len(scores)
#get maximum value of a list
max(scores)

type(scores[0])
type(scores[2])

seq = 'mamaprtein'
print("The length of " + seq + " is " + len(seq))
#KEY POINT: Python treats strings and numbers (int/float) differently.
#Need to explicitly convert number to string (str) to print.
print("The length of " + seq + " is " + str(len(seq)))
#Add a period.
print("The length of " + seq + " is " + str(len(seq)) + ".")
#Print protein sequence in quotes.
print("The length of '" + seq + "' is " + str(len(seq)) + ".")

#another way to print
print("The length of", seq, "is", len(seq))
print("The length of", seq, "is", len(seq),".")
print("The length of", seq, "is", len(seq),".",sep="")
print("The length of ", seq, " is ", len(seq),".",sep="")

#printing with format method
print("The length of {} is {}.".format(seq,len(seq)))
      
#All types in Python have methods, the syntax for method is
      #object.method(arguments)
#some str methods:
#count substring occurrences in string
seq.count('t')
seq.count('a')
#get uppercase string
seq.upper()
#strings are immutable (can't be modified)
seq
#if we want to use the upper case version, assign variable
seq2 = seq.upper()
seq2

#string indices and slicing
# mamaprtein
# 0123456789 
seq[0]
seq[0:4]
seq[:4]
seq[1:5]
seq[5:]
seq[-1]
seq[-2:]
seq[:-2]



